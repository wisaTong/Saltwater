package models

import base.UnitSpec
import mocks.MessageMock
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ModelSpec
  extends UnitSpec {

  "Test models " should {
    "return name and message" in {
      val testObj2 = MessageMock.messageForm
      testObj2.message mustBe "Test Message"
    }

  }
}
