package actor

import akka.actor._
import models.Message
import utillities.Json

object UserActor {
  def props(ref: ActorRef, toKill: ActorRef): Props = Props(UserActor(ref, toKill))
}

case class UserActor(ref: ActorRef, toKill: ActorRef) extends Actor {
  override def receive: Receive = {
    case jsonString: String => ref ! Json.toObject[Message](jsonString).get
  }

  override def postStop: Unit = {
    ref ! SocketCloseSignal(toKill)
  }
}

case class SocketCloseSignal(ref: ActorRef)
