package actor

import akka.actor._
import controllers.UserCount
import models.Message

object ChatRoomActor {
  def props: Props = Props[ChatRoomActor]
}

class ChatRoomActor extends WebSocketActor {
  override def receive: Receive = {
    case _: UserCount => sender ! actorList.size
    case actorRef: ActorRef => actorList += actorRef
    case signal: SocketCloseSignal => actorList -= signal.ref
    case msg: Message => actorList.foreach(actor => actor ! msg.toText)
  }
}
