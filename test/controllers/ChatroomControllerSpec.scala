package controllers

import base.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers.{POST, route, status, _}

@RunWith(classOf[JUnitRunner])
class ChatroomControllerSpec
  extends UnitSpec {

  "POST /api/createroom" should {
    "return 200 OK with roomname" in {
      val fakeRequest = FakeRequest(POST, "/api/createroom").withJsonBody(Json.parse("""{"name": "newRoom"}"""))
      val testObj = route(app, fakeRequest).get

      status(testObj) mustBe OK
      contentAsString(testObj) mustBe "New Room newRoom Created"
    }
  }

  "DELETE /api/deleteroom" should {
    "return 200 OK" in {
      val fakeRequest = FakeRequest(DELETE, "/api/deleteroom")
      val testObj = route(app, fakeRequest).get

      status(testObj) mustBe OK
      contentAsString(testObj) mustBe "deleted"
    }
  }
}
