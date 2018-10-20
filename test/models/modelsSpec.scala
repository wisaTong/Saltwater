package models

import org.joda.time.DateTime
import base.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import models.User

@RunWith(classOf[JUnitRunner])
class modelsSpec
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
