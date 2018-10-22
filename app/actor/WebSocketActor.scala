package actor

import akka.actor._
import scala.collection.mutable.ArrayBuffer

object Actor {
  var actorList: ArrayBuffer[ActorRef] = scala.collection.mutable.ArrayBuffer.empty
}

object WebSocketActor {
  def props(out: ActorRef):Props = Props(new WebSocketActor(out))
}

class WebSocketActor(out: ActorRef) extends Actor {
  override def receive: Receive = {
    case msg: String => {
      Actor.actorList.map( actor =>
        actor ! msg
      )
    }
  }
}
