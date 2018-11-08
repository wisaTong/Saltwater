package utilities

import base.UnitSpec
import mocks.MessageMock
import models.{Message, User}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import utillities.Json

@RunWith(classOf[JUnitRunner])
class JsonSpec
  extends UnitSpec {

  "toText" should {
    "return Json String " in {
      val testObj = MessageMock.messageForm

      testObj.toText must include("6010545811")
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

      val msg = Json.toObject[Message](MessageMock.messageJsonForm).get

      msg mustNot equal(None)
      msg.id mustBe "6010545901"
      msg.message mustBe "Test message"
      msg.time.year.getAsString mustBe "1999"

    }
  }

}
