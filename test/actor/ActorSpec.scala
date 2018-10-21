package actor

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.concurrent.duration._
import org.scalatest.{ BeforeAndAfterAll, FlatSpecLike, Matchers }
import akka.actor.{ Actor, Props, ActorSystem }
import akka.testkit.{ ImplicitSender, TestKit, TestActorRef, TestProbe }


@RunWith(classOf[JUnitRunner])
class ActorSpec(_system: ActorSystem) extends TestKit(_system)
with Matchers
with FlatSpecLike
with BeforeAndAfterAll{
  def this() = this(ActorSystem("AkkaQuickstartSpec"))

  override def afterAll: Unit = {
    shutdown(system)
  }

  "Test Actor" should "return the correct message" in {
    val testProbe = TestProbe()
    val actor = system.actorOf(WebSocketActor.props(testProbe.ref))
    actor ! "Hello"
    testProbe.expectMsg(500 millis,"Hello")
  }

}
