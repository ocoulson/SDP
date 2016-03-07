package pegs

/**
  * Created by Oliver Coulson on 07/03/2016.
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
