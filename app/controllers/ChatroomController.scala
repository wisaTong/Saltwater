package controllers

import actor.ChatSystem
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class ChatroomController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def create = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get

    ChatSystem.createRoom(name)

    Ok(s"$name chat room created")
  }

  def delete = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get

    ChatSystem.deleteRoom(name)
    Ok("deleted")
  }
}
