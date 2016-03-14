package handlers

import java.io.File
import org.clapper.classutil.ClassFinder
import com.softwaremill.macwire._
import pegs._

import scala.util.Random

/**
  * A class ColourHandler which is responsible for getting the available colours via reflection
  * An object ColourFactory which is responsible for instantiating colour objects on request.
  *
  * Created by Oliver Coulson and George Shiangoli on 07/03/2016.
  */

class ColourHandler {
  private val pathString = "."
  private val path = List(pathString).map(new File(_))
  private val finder = ClassFinder(path)
  private val classes = finder.getClasses().toIterator

  private val subclasses = ClassFinder.concreteSubclasses("pegs.Colour", classes)
  val instanceNames: List[String] = subclasses.map(i => i.name).toList
  val rawNames = instanceNames.map(i => i.substring(i.indexOf(".")+1))

  override def toString: String = {
    val rawString = rawNames.toString()
    rawString.substring(rawString.indexOf('(')+1, rawString.indexOf(')'))
  }
}



object ColourFactory {
  val colourHandler = wire[ColourHandler]
  var ids = List[String]()
  def newColour(name: Char): Option[Colour] = {

      if(colourHandler.rawNames.map(_.charAt(0).toUpper).contains(name)) {
        val instanceClass = Class.forName(colourHandler.instanceNames.find(i => i.contains(name)).get)
        val instanceConstructor = instanceClass.getConstructors()(0)
        val instance = Some(instanceConstructor.newInstance().asInstanceOf[Colour])
        instance
      } else None
  }

  def generateRandomColour(): Option[Colour] = {
    val colourHandler = wire[ColourHandler]
    val colours = colourHandler.rawNames
    val randomised = Random.shuffle(colours)
    ColourFactory.newColour(randomised.head.charAt(0).toUpper)
  }

}
