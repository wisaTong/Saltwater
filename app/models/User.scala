package models

import akka.actor.ActorRef
import utillities.Json

case class User(name: String, id: String, actorRef:ActorRef)
  extends Json
