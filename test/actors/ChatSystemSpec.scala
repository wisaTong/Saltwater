package actors

import java.util.concurrent.TimeUnit

import actor.ChatSystem
import akka.util.Timeout
import base.UnitSpec

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}

class ChatSystemSpec
  extends UnitSpec {

  val TEST_ACTOR_NAME: String = "test"

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  "createRoom" should {
    "create actor in ChatSystem" in {

      ChatSystem.createRoom(TEST_ACTOR_NAME)

      ChatSystem.system.actorSelection("/user/test").resolveOne.onComplete {
        case Success(actorRef) => actorRef.path.name mustBe TEST_ACTOR_NAME
        case _ => fail
      }
    }
  }

  "deleteRoom" should {
    "delete actor in ChatSystem" in {
      ChatSystem.createRoom(TEST_ACTOR_NAME)

      ChatSystem.deleteRoom(TEST_ACTOR_NAME)

      ChatSystem.system.actorSelection("/user/test").resolveOne.onComplete {
        case Failure(_) => succeed
        case Success(_) => fail
      }
    }
  }

  override def afterEach(): Unit = {
    ChatSystem.deleteRoom(TEST_ACTOR_NAME)
  }

}
