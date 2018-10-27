package actor

import akka.actor._

trait WebSocketActor extends Actor {
  override def receive: Receive
}
