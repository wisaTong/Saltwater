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

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  "createRoom" should {
    "create actor in ChatSystem" in {
      val TEST_ACTOR_NAME: String = "create"

      ChatSystem.createRoom(TEST_ACTOR_NAME)

      ChatSystem.system.actorSelection(s"/user/$TEST_ACTOR_NAME").resolveOne.onComplete {
        case Success(actorRef) => actorRef.path.name mustBe TEST_ACTOR_NAME
        case _ => fail
      }
    }
  }

  "deleteRoom" should {
    "delete actor in ChatSystem" in {
      val TEST_ACTOR_NAME: String = "delete"

      ChatSystem.createRoom(TEST_ACTOR_NAME)

      ChatSystem.deleteRoom(TEST_ACTOR_NAME)

      Thread.sleep(1000)
      ChatSystem.system.actorSelection(s"/user/$TEST_ACTOR_NAME").resolveOne.onComplete {
        case Failure(_) => succeed
        case Success(_) => fail
      }
    }
  }

}
