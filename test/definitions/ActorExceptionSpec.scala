package definitions

import java.util.concurrent.TimeUnit

import actor.ChatSystem
import akka.util.Timeout
import base.UnitSpec
import definitions.ActorException.{ActorNameNotUniqueException, ActorNotFoundException}

import scala.concurrent.Promise
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

class ActorExceptionSpec extends UnitSpec {

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  val TEST_ACTOR_NAME: String = "test"

  "create room with same name" should {
    "throw ActorNameNotUniqueException" in {

      Try {
        ChatSystem.createRoom(TEST_ACTOR_NAME)
        ChatSystem.createRoom(TEST_ACTOR_NAME)
      } match {
        case Failure(ex) => ex.getClass mustBe classOf[ActorNameNotUniqueException]
        case Success(_) => fail
      }

      ChatSystem.deleteRoom(TEST_ACTOR_NAME)

    }
  }

  // TODO improve this test (this test is incomplete)
  "search for room that does not exist" should {
    "throw ActorNotFoundException" in {

      val deleteRoom = {
        val promise = Promise[Unit]
        promise success ChatSystem.deleteRoom(TEST_ACTOR_NAME)
        promise
      }

      deleteRoom.future.onComplete {
        case Failure(ex) => ex.getClass mustBe classOf[ActorNotFoundException]
        case Success(_) => fail
      }

      Thread.sleep(500)
    }
  }

}
