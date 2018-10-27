package models

import org.joda.time.DateTime
import utillities.Json

case class Message(id: String
                   , message: String
                   , time: DateTime = DateTime.now())
  extends Json
