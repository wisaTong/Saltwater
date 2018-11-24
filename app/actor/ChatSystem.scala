package actor

import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, ActorSystem, PoisonPill}
import akka.util.Timeout
import definitions.ActorException.{ActorNameNotUniqueException, ActorNotFoundException}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success, Try}

object ChatSystem {

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  val system: ActorSystem = ActorSystem("ChatSystem")
  val lounge: ActorRef = system.actorOf(ChatRoomActor.props, "lounge")

  def createRoom(name: String): ActorRef = {
    Try {
      system.actorOf(ChatRoomActor.props, name)
    } match {
      case Success(ref) => ref
      case Failure(_) => throw new ActorNameNotUniqueException(name)
    }
  }

  def deleteRoom(name: String): Unit = {
    system.actorSelection(s"/user/$name").resolveOne.onComplete {
      case Success(actor) => actor ! PoisonPill
      case Failure(_) => throw new ActorNotFoundException(name)
    }
  }

}
