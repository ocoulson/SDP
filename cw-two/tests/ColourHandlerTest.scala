/**
  * Created by Oliver Coulson on 09/03/2016.
  */

import handlers.ColourFactory
import org.scalatest.FunSuite
import pegs._

class ColourHandlerTest extends FunSuite {
  test("An empty set should have size 0") {
    assert(Set.empty.size == 0)
  }
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
}
