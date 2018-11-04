package utillities

import com.fasterxml.jackson.databind.{ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.reflect.ClassTag

trait Json {
  import Json._
  def toText: String = mapper.writeValueAsString(this)
}


object Json {

  private val mapper = new ObjectMapper with ScalaObjectMapper
  mapper.registerModule(new JodaModule)
  mapper.registerModule(DefaultScalaModule)
  mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)

  def toJson(obj: AnyRef): String = mapper.writeValueAsString(obj)

  def toObject[T: Manifest](content: String)(implicit ct: ClassTag[T]): Option[T] = {
    if (content == null || content.isEmpty) None
    else Some(mapper.readValue[T](content))
  }

}

