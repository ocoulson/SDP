package pegs

/**
  * Trait and classes for the colour pegs. Can be extend by adding further classes.
  *
  * id field will be set at object construction by the ColourHandler class (working name)
  * Each colour has an associated name and abbreviated character, determined by the name.
  *
  * Created by Oliver Coulson and George Shiangoli on 07/03/2016.
  */
trait Colour {
  val symbol: Char

  override def equals(other: Any): Boolean = {
    if (!other.isInstanceOf[Colour]) false
    else {
      val otherColour = other.asInstanceOf[Colour]
      if (symbol.equals(otherColour.symbol)) true
      else false
    }
  }
}

final class Red(id: String) extends Colour {
  override val symbol: Char = 'R'
}
final class Orange(id: String) extends Colour {
  override val symbol: Char = 'O'
}
final class Purple(id: String) extends Colour {
  override val symbol: Char = 'P'
}
final class Green(id: String) extends Colour {
  override val symbol: Char = 'G'
}
final class Yellow(id: String) extends Colour {
  override val symbol: Char = 'Y'
}
final class Blue(id: String) extends Colour {
  override val symbol: Char = 'B'
}









