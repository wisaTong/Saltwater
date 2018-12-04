package controllers

import java.util.concurrent.TimeUnit

import actor.ChatSystem
import akka.actor.ActorRef
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents, Result}
import services.FirebaseService

import scala.concurrent.Await
import scala.concurrent.duration._
import akka.pattern.ask
import akka.util.Timeout

import scala.reflect.ClassTag

@Singleton
class ChatroomController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def create = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get

    ChatSystem.createRoom(name)
    FirebaseService.save(name)

    Created(s"$name chat room created")
  }

  def delete = Action(parse.json) { request =>
    val name = (request.body \ "name").asOpt[String].get

    ChatSystem.deleteRoom(name)
    FirebaseService.deleteRoom(name)

    Ok(s"$name chat room deleted")
  }

  implicit val timeout: Timeout = Timeout(FiniteDuration(10, TimeUnit.SECONDS))

  def getUserCount(roomName: String) = Action { request =>
    val ref: ActorRef = Await.result(ChatSystem.getActor(roomName), 1 second)
    val userCount: Int = Await.result(ref ? UserCount() mapTo ClassTag(classOf[Int]), 1 second)
    Ok(userCount.toString)
  }

}

case class UserCount()
