package controllers

import play.api.mvc._
import play.api.libs.streams.ActorFlow
import javax.inject.Inject
import akka.actor.{ActorSystem, Props}
import akka.stream.Materializer
import actor.{ChatSystem, UserActor}

class ActorController @Inject()(cc:ControllerComponents)
                               (implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  def socket: WebSocket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { ref =>
      ChatSystem.lounge ! ref
      UserActor.props
    }
  }

}
