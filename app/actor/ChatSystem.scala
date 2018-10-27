package actor

import akka.actor.{ActorRef, ActorSystem, Props}

object ChatSystem {
  val system: ActorSystem = ActorSystem("ChatSystem")
  val lounge = system.actorOf(Props[PublicRoomActor])
}
