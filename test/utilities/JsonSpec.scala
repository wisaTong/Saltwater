package utilities

import base.UnitSpec
import mocks.MessageMock
import models.Message
import org.joda.time.DateTime
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import utillities.Json

@RunWith(classOf[JUnitRunner])
class JsonSpec
  extends UnitSpec {

  "toText" should {
    "return Json String " in {
      val testObj = MessageMock.messageForm

      testObj.toText must include(testObj.id)
      testObj.toText must include(testObj.message)
    }
  }

  "toObject" should {
    "return Object with correct attributes" in {

      val msg = Json.toObject[Message](MessageMock.messageJsonForm).get

      msg mustNot equal(None)
      msg.id mustBe MessageMock.messageForm.id
      msg.message mustBe MessageMock.messageForm.message
      msg.time.getClass mustBe classOf[DateTime]

    }
  }

}
