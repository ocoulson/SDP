/**
  * Created by Oliver Coulson on 11/03/2016.
  */

import game.{Guess, SecretCode}
import com.softwaremill.macwire._
import handlers.{ResponseHandler, ColourFactory}
import org.scalatest.FunSuite
import pegs.{White, Black}

class ResponseHandlerTest extends FunSuite{
  val secretCode1 = new SecretCode(Vector(ColourFactory.newColour('R').get, ColourFactory.newColour('G').get,
    ColourFactory.newColour('B').get, ColourFactory.newColour('R').get))
  val responseHandler1 = wire[ResponseHandler]

  test("The response of a correct guess should be 4 black pegs") {
    val correctGuess = new Guess(Vector(ColourFactory.newColour('R').get,
                                        ColourFactory.newColour('G').get,
                                        ColourFactory.newColour('B').get,
                                        ColourFactory.newColour('R').get))

    val response = responseHandler1.getResponse(correctGuess)
    val blacks = response.filter(rp => rp.isInstanceOf[Black])

    println(response)
    assert(response.length == secretCode1.length)
  }

  test("The response of a guess all but one correct and in the correct positions, there should be" +
   " X black pegs where X is the number of correct guesses and no white pegs") {
    val guess = new Guess(Vector(ColourFactory.newColour('R').get,
                                ColourFactory.newColour('G').get,
                                ColourFactory.newColour('B').get,
                                ColourFactory.newColour('Y').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.filter(rp => rp.isInstanceOf[Black])
    val whites = response.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 3)
    assert(whites.isEmpty)
  }

  test("The response of a guess with 2 fully correct, one partially correct and one incorrect should "+
    "be 2 black pegs and one white peg") {
    val guess = new Guess(Vector(ColourFactory.newColour('R').get,
                                ColourFactory.newColour('G').get,
                                ColourFactory.newColour('Y').get,
                                ColourFactory.newColour('B').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.filter(rp => rp.isInstanceOf[Black])
    val whites = response.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 2)
    assert(whites.length == 1)
  }

  test("The response of a guess with 2 fully correct and 2 incorrect should be 2 black pegs and no whites.") {
    val guess = new Guess(Vector(ColourFactory.newColour('R').get,
                                ColourFactory.newColour('G').get,
                                ColourFactory.newColour('Y').get,
                                ColourFactory.newColour('O').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.filter(rp => rp.isInstanceOf[Black])
    val whites = response.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 2)
    assert(whites.isEmpty)
  }

  test("The response of a guess with 2 fully correct and 2 partially correct should be 2 black pegs and 2 whites.") {
    val guess = new Guess(Vector(ColourFactory.newColour('R').get,
                                ColourFactory.newColour('G').get,
                                ColourFactory.newColour('R').get,
                                ColourFactory.newColour('B').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.filter(rp => rp.isInstanceOf[Black])
    val whites = response.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 2)
    assert(whites.length == 2)
  }

  test("The response of a guess with 1 fully correct and 2 partially correct should be 1 black peg and 2 whites.") {
    val guess = new Guess(Vector(ColourFactory.newColour('B').get,
                                ColourFactory.newColour('G').get,
                                ColourFactory.newColour('R').get,
                                ColourFactory.newColour('O').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.filter(rp => rp.isInstanceOf[Black])
    val whites = response.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 1)
    assert(whites.length == 2)
  }

}
