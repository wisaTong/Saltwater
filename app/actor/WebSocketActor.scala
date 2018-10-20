package actor

import akka.actor._

object Actor {
  var actorList = scala.collection.mutable.ArrayBuffer.empty[ActorRef]
}

object WebSocketActor {
  def props(out: ActorRef):Props = Props(new WebSocketActor(out))
}

class WebSocketActor(out: ActorRef) extends Actor {
  var actor = Actor
  def receive = {
    case msg: String => {
      actor.actorList.map(actor =>
        actor ! msg
      )
    }
  }
  override def preStart(): Unit = {
    Actor.actorList += out
  }
  override def postStop(): Unit = {
    Actor.actorList -= out
  }
}
