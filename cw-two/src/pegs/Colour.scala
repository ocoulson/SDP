package pegs

/**
  * Created by Oliver Coulson on 07/03/2016.
  */
sealed trait Colour {
  val id: Int
  val name: String
  val symbol: Char = name.charAt(0).toUpper
}

class Red extends Colour
class Yellow extends Colour
class Orange extends Colour
class Blue extends Colour
class Green extends Colour
class Purple extends Colour






