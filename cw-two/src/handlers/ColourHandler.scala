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

  private val path = List("/Users/olliecoulson/Documents/IntelliJProjects/MSc/SDP").map(new File(_))
  private val finder = ClassFinder(path)
  private val classes = finder.getClasses().toIterator

  private val subclasses = ClassFinder.concreteSubclasses("pegs.Colour", classes)
  val instanceNames: List[String] = subclasses.map(i => i.name).toList
  val rawNames = instanceNames.map(i => i.substring(i.indexOf(".")+1))


}

object main extends App{
val option = ColourFactory.newColour("Red")
  if (option != None) {
    println(option.get.name)
    println(ColourFactory.ids.head)
  }


}

object ColourFactory {
  val colourHandler = wire[ColourHandler]
  var ids = List[String]()
  def newColour(name: String): Option[Colour] = {

      if(colourHandler.rawNames.contains(name)) {
        val instanceClass = Class.forName(colourHandler.instanceNames.find(i => i.contains(name)).get)
        val instanceConstructor = instanceClass.getConstructors()(0)
        val id: String = generateId(name)
        val instance = Some(instanceConstructor.newInstance(id).asInstanceOf[Colour])
        instance
      } else None
  }
  def generateId(name:String) : String = {
    val prefix = name.charAt(0).toUpper
    val suffix = ids.size
    val id: String = prefix.toString + suffix.toString

    ids = id :: ids

    id
  }

}
