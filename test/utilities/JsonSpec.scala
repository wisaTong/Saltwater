package utilities

import base.UnitSpec
import models.{Message, User}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import utillities.Json

@RunWith(classOf[JUnitRunner])
class JsonSpec
  extends UnitSpec {

  "toText" should {
    "return Json String " in {
      val testObj = Message("wisa", "Test Message")

      testObj.toText must include("wisa")
      testObj.toText must include("Test Message")
    }
  }

  "toObject" should {
    "return Object with correct attributes" in {
      val jsonString =
        """
          | {
          | "name": "wisa",
          | "id": "6010545901"
          | }
        """.stripMargin

      val user = Json.toObject[User](jsonString).get

      user.name mustBe "wisa"
      user.id mustBe "6010545901"
    }
  }

}
