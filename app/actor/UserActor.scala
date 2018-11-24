package actor

import akka.actor._
import models.Message
import utillities.Json

object UserActor {
  def props(ref: ActorRef): Props = Props(UserActor(ref))
}

case class UserActor(ref: ActorRef) extends Actor {
  override def receive: Receive = {
    case jsonString: String => ref ! Json.toObject[Message](jsonString).get
  }
}
