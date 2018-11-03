package actor

import akka.actor._

object PublicRoomActor {
  def props: Props = Props(new PublicRoomActor)
}

class PublicRoomActor extends WebSocketActor {
  override def receive: Receive = {
    case actorRef: ActorRef => actorList += actorRef
    case msg: Message => actorList.foreach(actor => actor ! toJson(msg))
  }
}
