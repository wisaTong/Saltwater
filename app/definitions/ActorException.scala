package definitions

object ActorException {

  class ActorNotFoundException()
    extends Exception("This actor doesn't exist.")

  class ActorNameNotUniqueException(s: String)
    extends Exception(s"This name ($s) has already been used.")

}
