package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class ChatroomController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {
  def create = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get
    // TODO createRoom(name)
    Ok(s"New Room $name Created")
  }

  def delete = Action { request =>
    Ok("deleted")
  }
}
