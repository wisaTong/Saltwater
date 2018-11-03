package actor

import akka.actor._

object PrivateRoomActor {
  def props: Props = Props[PrivateRoomActor]
}

class PrivateRoomActor extends WebSocketActor {
  override def receive: Receive = {
    case actorRef: ActorRef => actorList += actorRef
    case msg: String => actorList.foreach(actor => actor ! msg)
  }
}
