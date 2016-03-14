package pegs

/**
  * Trait and classes for the colour pegs. Can be extend by adding further classes.
  *
  * Each colour has an associated abbreviated character.
  *
  * Created by Oliver Coulson and George Shiangoli on 07/03/2016.
  */
trait Colour {
  val symbol: Char

  /**
    * Determines whether this Colour is equal to another.
    *
    * @param other the Colour that this Colour is to be compared to
    * @return true if both Colours are of the same type, false otherwise.
    */
  override def equals(other: Any): Boolean = {
    if (!other.isInstanceOf[Colour]) false
    else {
      val otherColour = other.asInstanceOf[Colour]
      if (symbol.equals(otherColour.symbol)) true
      else false
    }
  }
}

final class Red extends Colour {
  override val symbol: Char = 'R'
}
final class Orange extends Colour {
  override val symbol: Char = 'O'
}
final class Purple extends Colour {
  override val symbol: Char = 'P'
}
final class Green extends Colour {
  override val symbol: Char = 'G'
}
final class Yellow extends Colour {
  override val symbol: Char = 'Y'
}
final class Blue extends Colour {
  override val symbol: Char = 'B'
}









