package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import utillities.Config

@Singleton
class SystemController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def version = Action {
    Ok(s"name: ${Config("name")}, version: ${Config("version")}\n")
  }

}
