package handlers

import org.clapper.classutil.ClassFinder
import pegs._
/**
  * Created by Oliver Coulson on 07/03/2016.
  */
class ColourHandler {

  //TODO: Use reflection to get colourpool


  //TODO: Use ColourFactory to build and return colour objects

  val colour = ColourFactory.newColour('R', "1")


}

object main extends App{
  val ch = new ColourHandler
  print(ch.colour.toString)

}
import com.softwaremill.macwire._
object ColourFactory {
  def newColour(symbol: Char, id: String): Colour = {

    symbol match {
      case 'R' =>  wire[Red]
      case 'Y' =>  wire[Yellow]
      case 'P' =>  wire[Purple]
      case 'G' =>  wire[Green]
      case 'B' =>  wire[Blue]
      case 'O' =>  wire[Orange]
    }
  }
}
