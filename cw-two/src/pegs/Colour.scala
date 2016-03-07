package pegs

/**
  * Trait and classes for the colour pegs. Can be extend by adding further classes.
  *
  * id field will be set at object construction by the ColourHandler class (working name)
  * Each colour has an associated name and abbreviated character, determined by the name.
  *
  * Created by Oliver Coulson and George Shiangoli on 07/03/2016.
  */
sealed trait Colour {
  val name: String
  val symbol = name.charAt(0).toUpper
}

class Red(id: String) extends Colour {
  override val name: String = "red"
}
class Orange(id: String) extends Colour {
  override val name: String = "orange"
}
class Purple(id: String) extends Colour {
  override val name: String = "purple"
}
class Green(id: String) extends Colour {
  override val name: String = "green"
}
class Yellow(id: String) extends Colour {
  override val name: String = "yellow"
}
class Blue(id: String) extends Colour {
  override val name: String = "blue"
}






