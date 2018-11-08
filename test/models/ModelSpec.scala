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
      val testObj = User("Sea","123",null)
      val testObj2 = MessageMock.messageForm
      testObj.name mustBe "Sea"
      testObj2.message mustBe "Test Message"
    }

  }
}
