package models

import org.joda.time.DateTime
import utillities.Json

case class Message(send: String
                   , message: String
                   , destination: String
                   , time: DateTime = DateTime.now()
                  )
  extends Json
