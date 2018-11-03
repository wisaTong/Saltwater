package actor

import akka.actor.{ActorRef, ActorSystem}

object ChatSystem {
  val system: ActorSystem = ActorSystem("ChatSystem")
  val lounge = system.actorOf(PublicRoomActor.props)

  def createRoom(name: String): ActorRef =
    system.actorOf(PrivateRoomActor.props, name)
}
