package actor

import akka.actor._
import models.Message
import utillities.Json

object UserActor {
  def props: Props = Props(new UserActor)
}

class UserActor extends Actor {
  override def receive: Receive = {
      case msg: String => ChatSystem.lounge ! Json.toObject[Message](msg)
  }
}
