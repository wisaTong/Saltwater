package actor

import akka.actor._
import scala.collection.mutable.ArrayBuffer

trait WebSocketActor extends Actor {
  var actorList: ArrayBuffer[ActorRef] = ArrayBuffer.empty
  override def receive: Receive
}
