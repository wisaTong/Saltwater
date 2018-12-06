package definitions

import java.util.concurrent.TimeUnit

import actor.ChatSystem
import akka.actor.ActorNotFound
import akka.util.Timeout
import base.UnitSpec
import definitions.ActorException.ActorNameNotUniqueException

import scala.concurrent.Await
import scala.concurrent.duration.{FiniteDuration, _}
import scala.util.{Failure, Success, Try}

class ActorExceptionSpec extends UnitSpec {

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))


  "create room with same name" should {
    "throw ActorNameNotUniqueException" in {

      val TEST_CREATE: String = "TEST"

      Try {
        ChatSystem.createRoom(TEST_CREATE)
        ChatSystem.createRoom(TEST_CREATE)
      } match {
        case Failure(ex) => ex.getClass mustBe classOf[ActorNameNotUniqueException]
        case Success(_) => fail
      }

      ChatSystem.deleteRoom(TEST_CREATE)

    }
  }

  "search for room that does not exist" should {
    "throw ActorNotFound" in {

      val TEST_DELETE: String = "delete"

      Try {
        Await.result(ChatSystem.getActor(TEST_DELETE), 1 second)
      } match {
        case Success(ref) => fail(s"should not found ActorRef ${ref.path.name}")
        case Failure(ex) => ex.getClass mustBe classOf[ActorNotFound]
      }

    }
  }

}
