package exceptions

import akka.actor.ActorRef

class ActorNotFoundException(message: String, actor: ActorRef ,cause:Throwable) extends RuntimeException(ActorNotFoundException.customMessage(actor), cause)

object ActorNotFoundException  {
  def apply(actor: ActorRef): ActorNotFoundException = this(customMessage(actor), null)
  def apply(cause: Throwable) : ActorNotFoundException = this(Option(cause).map(_.toString).orNull, cause)
  def apply() : ActorNotFoundException = this(null, null)

  private def customMessage(actor: ActorRef): String = "Invalid actor."
}
