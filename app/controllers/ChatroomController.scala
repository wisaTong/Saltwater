package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class ChatroomController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {
  def create = Action(parse.json) { request =>
    val option = (request.body \ "name").asOpt[String].map { name =>
      //      createRoom(name)
      Ok(s"New Room $name Created")
    }
    option.get
  }
  def delete = Action { request=>
    Ok("deleted")
  }
}