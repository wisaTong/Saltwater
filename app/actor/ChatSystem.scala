package actor

import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, ActorSystem, FSM, PoisonPill, Status}
import akka.util.Timeout
import definitions.ActorException.{ActorNameNotUniqueException, ActorNotFoundException}
import play.api.Logger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}

object ChatSystem {

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  val system: ActorSystem = ActorSystem("ChatSystem")
  val lounge: ActorRef = system.actorOf(ChatRoomActor.props, "lounge")

  def createRoom(name: String): ActorRef = {
    system.actorOf(ChatRoomActor.props, name) match {
      case actor: ActorRef => {
        Logger.info(s"successfully create actor ${actor.path.name}")
        actor
      }
      case _ => throw new ActorNameNotUniqueException(name)
    }
  }

  def deleteRoom(name: String): Unit = {
    system.actorSelection(s"/user/$name").resolveOne.onComplete {
      case Success(actor) => {
        actor ! PoisonPill
        println("deleted")
      }
      case Failure(_) => {
        throw new ActorNotFoundException()
        Logger.warn(s"cannot find actor named '$name'")

      }
    }
  }

}
