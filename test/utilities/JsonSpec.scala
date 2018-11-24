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

      testObj.toText must include(MessageMock.messageForm.sender)
      testObj.toText must include(MessageMock.messageForm.message)
      testObj.toText must include(MessageMock.messageForm.destination)
    }
  }

  "toObject" should {
    "return Object with correct attributes" in {

      val msg = Json.toObject[Message](MessageMock.messageJsonForm).get

      msg mustNot equal(None)
      msg.sender mustBe MessageMock.messageForm.sender
      msg.message mustBe MessageMock.messageForm.message
      msg.destination mustBe MessageMock.messageForm.destination
      msg.time.getClass mustBe classOf[DateTime]

    }
  }

}
