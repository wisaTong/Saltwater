package actor

import akka.actor._
import scala.collection.mutable.ArrayBuffer

object PublicRoomActor {
  def props: Props = Props(new PublicRoomActor)
}

class PublicRoomActor extends WebSocketActor {
  override var actorList: ArrayBuffer[ActorRef] = scala.collection.mutable.ArrayBuffer.empty
  override def receive: Receive = {
    case actorRef: ActorRef => actorList += actorRef
    case msg: String => actorList.foreach(actor => actor ! msg)
  }
}
