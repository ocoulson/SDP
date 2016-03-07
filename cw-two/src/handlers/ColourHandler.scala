package handlers

import pegs._
/**
  * Created by Oliver Coulson on 07/03/2016.
  */
class ColourHandler {


  //TODO: Use ColourFactory to build and return colour objects

  val colourOption = ColourFactory.newColour("red", "1")


}

object main extends App{
  val ch = new ColourHandler
  if (ch.colourOption != None) {
    println(ch.colourOption.get.name)
  } else
    print(None)

}

object ColourFactory {
  def newColour(colour: String, id: String): Option[Colour] = {

    colour match {
      case "red" => return Some(new Red(id))
      case "yellow" => return Some(new Yellow(id))
      case "purple" => return Some(new Purple(id))
      case "green" => return Some(new Green(id))
      case "blue" => return Some(new Blue(id))
      case "orange" => return Some(new Orange(id))

      case _ => return None
    }
  }
}
