package actor

import akka.actor._
import models.Message

object ChatRoomActor {
  def props: Props = Props[ChatRoomActor]
}

class ChatRoomActor extends WebSocketActor {
  override def receive: Receive = {
    case actorRef: ActorRef => actorList += actorRef
    case msg: Message => actorList.foreach(actor => actor ! msg.toText)
  }
}
