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
  val name: String
  lazy val symbol = name.charAt(0).toUpper
}

final class Red(id: String) extends Colour {
  override val name: String = "red"
}
final class Orange(id: String) extends Colour {
  override val name: String = "orange"
}
final class Purple(id: String) extends Colour {
  override val name: String = "purple"
}
final class Green(id: String) extends Colour {
  override val name: String = "green"
}
final class Yellow(id: String) extends Colour {
  override val name: String = "yellow"
}
final class Blue(id: String) extends Colour {
  override val name: String = "blue"
}









