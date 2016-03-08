package handlers

import java.io.File
import java.lang.Class
import org.clapper.classutil.ClassFinder
import com.softwaremill.macwire._
import pegs._
/**
  * Created by Oliver Coulson on 07/03/2016.
  */
class ColourHandler {

  //TODO: Use reflection to get colourpool
  val path = List("/Users/olliecoulson/Documents/IntelliJProjects/MSc/SDP").map(new File(_))
  val finder = ClassFinder(path)
  val classes = finder.getClasses().toIterator

  val subclasses = ClassFinder.concreteSubclasses("pegs.Colour", classes)
  val instanceNames: List[String] = subclasses.map(i => i.name).toList
  val rawNames = instanceNames.map(i => i.substring(i.indexOf(".")+1))

//  val redClass = Class.forName(i.name)
//  val redClassConstructor = redClass.getConstructors()(0)
//  val param: String = "R1"
//  val instance = redClassConstructor.newInstance(param)
//  instance



  //TODO: Use ColourFactory to build and return colour objects

  val colour = ColourFactory.newColour('R', "1")


}

object main extends App{
  val ch = new ColourHandler
  //print(ch.colour.toString)
  //ch.subclasses.foreach(println(_))
  println(ch.instanceNames.toString())
  println(ch.rawNames.toString())


}

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
