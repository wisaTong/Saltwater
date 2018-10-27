package actor

import akka.actor._
import scala.collection.mutable.ArrayBuffer

object PublicRoomActor {
  def props(out: ActorRef):Props = Props(new PublicRoomActor(out))
}

object Actor {
  var publicActorList: ArrayBuffer[ActorRef] = scala.collection.mutable.ArrayBuffer.empty
}

class PublicRoomActor(out: ActorRef) extends WebSocketActor {
  override def receive: Receive = {
    case actorRef: ActorRef => Actor.publicActorList += actorRef
    case msg: String => Actor.publicActorList.foreach( actor => actor ! msg )
  }
}
