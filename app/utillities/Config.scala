package utillities

import com.typesafe.config.ConfigFactory

object Config {

  private val config = ConfigFactory.load

  def apply(key: String): String = config.getString(key)

  def bool(key: String): Boolean = config.getBoolean(key)

}
