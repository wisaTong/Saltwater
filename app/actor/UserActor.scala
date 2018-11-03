package actor

import akka.actor._

object UserActor {
  def props: Props = Props(new UserActor)
}

class UserActor extends Actor {
  override def receive: Receive = {
    case msg: Message => ChatSystem.lounge ! toObject(msg)(Message).get
  }
}
