package definitions

object ActorException {

  class ActorNotFoundException(s: String)
    extends Exception(s"actor with name [$s] doesn't exist.")

  class ActorNameNotUniqueException(s: String)
    extends Exception(s"This name ($s) has already been used.")

}
