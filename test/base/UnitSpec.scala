package base

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach}
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite

import scala.reflect.ClassTag

abstract class UnitSpec extends PlaySpec
  with GuiceOneAppPerSuite
  with BeforeAndAfterEach
  with BeforeAndAfterAll {

  protected def preExecute(): Unit = {}

  protected def as[T: ClassTag] = app.injector.instanceOf[T]

}
