package mocks

import models.Message
import org.joda.time.DateTime

class MessageMock {

  def createMessage(message: String): Message = {
    Message(java.util.UUID.randomUUID().toString,message,DateTime.now())
  }

}
