package controllers

import play.api.mvc._
import play.api.libs.streams.ActorFlow
import javax.inject.Inject
import akka.actor.ActorSystem
import akka.stream.Materializer

class ActorController @Inject()(cc:ControllerComponents)
                               (implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {
  import actor.WebSocketActor

  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { ref =>
      WebSocketActor.props(ref)
    }
  }

}