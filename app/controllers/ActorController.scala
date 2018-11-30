package controllers

import actor.{ChatSystem, UserActor}
import akka.actor.ActorSystem
import akka.stream.Materializer
import javax.inject.Inject
import play.api.libs.streams.ActorFlow
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.duration._

class ActorController @Inject()(cc:ControllerComponents)
                               (implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  def socket(chatName: String): WebSocket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { ref =>
      val chatActor = Await.result(ChatSystem.getActor(chatName), 1 second)

      chatActor ! ref

      UserActor.props(chatActor)
    }
  }

}
