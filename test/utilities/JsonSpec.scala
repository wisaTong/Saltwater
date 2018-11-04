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
      val userJson =
        """
          | {
          |   "name": "wisa"
          |   , "id": "6010545901"
          | }
        """.stripMargin

      val user = Json.toObject[User](userJson).get

      user mustNot equal(None)
      user.name mustBe "wisa"
      user.id mustBe "6010545901"

      val msgJson =
        """
          | {
          |   "id": "6010545901"
          |   , "message": "Test message"
          |   , "time": "1999-05-29T07:42:22Z"
          | }
        """.stripMargin

      val msg = Json.toObject[Message](msgJson).get

      msg mustNot equal(None)
      msg.id mustBe "6010545901"
      msg.message mustBe "Test message"
      msg.time.year.getAsString mustBe "1999"

    }
  }

}
