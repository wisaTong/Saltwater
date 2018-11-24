package controllers

import actor.ChatSystem
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.FirebaseService

@Singleton
class ChatroomController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def create = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get

    ChatSystem.createRoom(name)
    FirebaseService.save(name)
    Ok(s"$name chat room created")
  }

  def delete = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get

    ChatSystem.deleteRoom(name)

    Ok("deleted")
  }
}
