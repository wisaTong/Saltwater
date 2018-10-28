package actor

import akka.actor.ActorSystem

object ChatSystem {
  val system: ActorSystem = ActorSystem("ChatSystem")
  val lounge = system.actorOf(PublicRoomActor.props)
}
