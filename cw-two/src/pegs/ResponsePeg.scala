package pegs

/**
  * ResponsePeg objects will be used to give the player feedback on their guesses. They are either black or white.
  * A black peg will indicate a correct colour in the correct place.
  * A white peg will indicate a correct colour but in the wrong place.
  *
  * Created by Oliver Coulson and George Shiangoli on 07/03/2016.
  */
sealed trait ResponsePeg {

  val name: String
}

class Black extends ResponsePeg {
  override val name: String = "Black"
}
class White extends ResponsePeg {
  override val name: String = "White"
}
