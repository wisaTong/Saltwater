package actor

import akka.actor._

object ChatRoomActor {
  def props: Props = Props[ChatRoomActor]
}

class ChatRoomActor extends WebSocketActor {
  override def receive: Receive = {
    case actorRef: ActorRef => actorList += actorRef
    case msg: String => actorList.foreach(actor => actor ! msg)
  }
}
