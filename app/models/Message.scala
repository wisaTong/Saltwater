package models

import org.joda.time.DateTime

case class Message(id:String,message:String,time: DateTime = DateTime.now())
