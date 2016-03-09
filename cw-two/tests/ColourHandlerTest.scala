/**
  * Created by Oliver Coulson on 09/03/2016.
  */


import handlers.{ColourHandler, ColourFactory}
import org.clapper.classutil.ClassFinder
import org.scalatest.FunSuite
import pegs._

class ColourHandlerTest extends FunSuite {
  test("An empty set should have size 0") {
    assert(Set.empty.size == 0)
  }

  //ColourFactory Tests
  test("Colour factory returns an object in an Option when given a valid string") {
    val option = ColourFactory.newColour("Red")
    assert(option.isInstanceOf[Option[Colour]])
  }
  test("The option from ColourFactory contains a Colour of the type specified") {
    val option = ColourFactory.newColour("Red")
    val redColour = option.get
    assert(redColour.isInstanceOf[Colour])
    assert(redColour.isInstanceOf[Red])
  }
  test("Colour factory returns an Option which is None when given an invalid string") {
    val option = ColourFactory.newColour("red")//should have upper case first letter
    assert(option.isEmpty)
  }
  test("Colour factory returns an Option which is None when given an empty string") {
    val option = ColourFactory.newColour("")//should have upper case first letter
    assert(option.isEmpty)
  }

  //ColourHandler Tests

  test("ColourHandler field 'instanceNames' contains all subclasses of trait Colour") {
    val finder = ClassFinder()
    val classes = finder.getClasses().toIterator

    val subclasses = ClassFinder.concreteSubclasses("pegs.Colour", classes)
    val instanceNames: List[String] = subclasses.map(i => i.name).toList

    val colourHandler = new ColourHandler

    assert(colourHandler.instanceNames.equals(instanceNames))
  }
  test("ColourHandler field 'rawNames' contains all subclasses of trait Colour") {
    val finder = ClassFinder()
    val classes = finder.getClasses().toIterator

    val subclasses = ClassFinder.concreteSubclasses("pegs.Colour", classes)
    val instanceNames: List[String] = subclasses.map(i => i.name).toList
    val rawNames = instanceNames.map(i => i.substring(i.indexOf(".")+1))
    val colourHandler = new ColourHandler

    assert(colourHandler.rawNames.equals(rawNames))
  }
}
