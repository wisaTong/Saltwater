package actor

import akka.actor._
import models.Message
import utillities.Json

object UserActor {
  def props: Props = Props[UserActor]
}

class UserActor extends Actor {
  override def receive: Receive = {
    case jsonString: String => ChatSystem.lounge ! Json.toObject[Message](jsonString).get
  }
}
