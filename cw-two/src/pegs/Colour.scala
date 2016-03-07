package pegs

/**
  * Created by Oliver Coulson on 07/03/2016.
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






