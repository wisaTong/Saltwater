package models

import base.UnitSpec
import org.joda.time.DateTime
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ModelSpec
  extends UnitSpec {

  "Test models " should {
    "return name and message" in {
      val testObj = User("Sea","123")
      val testObj2 = Message("123","Hello",DateTime.now)
      testObj.name mustBe "Sea"
      testObj2.message mustBe "Hello"
    }

  }
}
