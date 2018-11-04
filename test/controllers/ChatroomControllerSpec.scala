package controllers

import base.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import play.api.libs.json.Json
import play.api.test.{FakeHeaders, FakeRequest}
import play.api.test.Helpers.{POST, route, status, _}
import utillities.Config

@RunWith(classOf[JUnitRunner])
class ChatroomControllerSpec
  extends UnitSpec {

  "POST /api/createroom" should {
    "return Get Request and Deleted" in {
      val fakeRequest1 = FakeRequest(POST, "/api/createroom").withJsonBody(Json.parse("""{"name": "newRoom"}"""))
      val testObj1 = route(app, fakeRequest1).get
      status(testObj1) mustBe OK
      contentAsString(testObj1) mustBe "New Room newRoom Created"

      val fakeRequest2 = FakeRequest(DELETE,"/api/deleteroom")
      val testObj2 = route(app,fakeRequest2).get
      status(testObj2) mustBe OK
      contentAsString(testObj2) mustBe "deleted"
    }

  }
}