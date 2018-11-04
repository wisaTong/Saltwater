package actor

import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, ActorSystem, PoisonPill}
import akka.util.Timeout
import play.api.Logger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}

object ChatSystem {

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  val system: ActorSystem = ActorSystem("ChatSystem")
  val lounge: ActorRef = system.actorOf(ChatRoomActor.props)

  def createRoom(name: String): ActorRef =
    system.actorOf(ChatRoomActor.props, name)

  def deleteRoom(name: String): Unit = {
    system.actorSelection(s"/user/$name").resolveOne.onComplete {
      case Success(actor) => actor ! PoisonPill
      case Failure(_) => Logger.warn(s"cannot find actor named '$name'")
    }
  }

}
