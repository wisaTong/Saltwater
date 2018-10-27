package actor

import akka.actor._

class UserActor extends Actor {
  override def receive: Receive = {
    case msg: String => ChatSystem.lounge ! msg
  }
}
