package controllers

import base.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import play.api.test.FakeRequest
import play.api.test.Helpers.{GET, route, status, _}
import utillities.Config

@RunWith(classOf[JUnitRunner])
class SystemControllerSpec
  extends UnitSpec {

  "GET /" should {
    "return OK with name and version" in {
      val testObj = route(app, FakeRequest(GET, "/")).get

      status(testObj) mustBe OK
      contentAsString(testObj) must include(Config("version"))
    }

  }
}
