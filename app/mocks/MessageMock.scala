package mocks

import models.Message
import org.joda.time.DateTime

object MessageMock {

  val messageForm: Message =
    Message("6010545811"
      , "Test Message"
      , "lounge"
      , DateTime.now
    )

  val longMessageForm: Message =
    Message("6010546664"
      , "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis, " +
        "ratione fugit. Atque commodi autem velit sit est dolores aut dignissimos, " +
        "tenetur, impedit quaerat quo odio aliquam optio reiciendis, in id?"
      , "lounge"
      , DateTime.now
    )

  val messageJsonForm: String =
    """
      | {
      |   "sender": "6010545811"
      |   , "message": "Test Message"
      |   , "destination": "lounge"
      |   , "time": "1999-05-29T07:42:22Z"
      | }
    """.stripMargin

}
