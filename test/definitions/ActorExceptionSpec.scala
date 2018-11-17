package definitions

import java.util.concurrent.TimeUnit

import actor.ChatSystem
import play.api.Logger
import akka.util.Timeout
import base.UnitSpec
import definitions.ActorException.{ActorNameNotUniqueException, ActorNotFoundException}

import scala.concurrent.duration.FiniteDuration

class ActorExceptionSpec extends UnitSpec{

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  val TEST_ACTOR_NAME: String = "test"

  "duplicateRoom" should {
    "throw ActorNameNotUniqueException" in {

      ChatSystem.createRoom(TEST_ACTOR_NAME)

      try {
        ChatSystem.createRoom(TEST_ACTOR_NAME)
      } catch {
        case _: Exception => Logger.info(new ActorNameNotUniqueException("test").getMessage)
      }

      ChatSystem.deleteRoom(TEST_ACTOR_NAME)


    }
  }

  "roomNotFound" should {
    "throw ActorNameFoundException" in {

      try {
        ChatSystem.deleteRoom(TEST_ACTOR_NAME)
      } catch {
        case _: Exception => Logger.info(new ActorNotFoundException().getMessage)
      }


    }
  }

}
