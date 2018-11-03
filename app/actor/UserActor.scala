package actor

import akka.actor._

object UserActor {
  def props: Props = Props[UserActor]
}

class UserActor extends Actor {
  override def receive: Receive = {
    case msg: String => ChatSystem.lounge ! msg
  }
}
