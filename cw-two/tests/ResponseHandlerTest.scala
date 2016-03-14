/**
  * Created by Oliver Coulson on 11/03/2016.
  */

import com.softwaremill.macwire._
import gameStructures.{Response, SecretCode, Guess}
import handlers.{ResponseFactory, ResponseHandler, ColourFactory}
import org.scalatest.FunSuite
import pegs.{White, Black}

class ResponseHandlerTest extends FunSuite{
  val secretCode1 = new SecretCode(Vector(ColourFactory.newColour('R').get, ColourFactory.newColour('G').get,
    ColourFactory.newColour('B').get, ColourFactory.newColour('R').get))
  val responseHandler1 = new ResponseHandler(secretCode1)

  val secretCode2 = new SecretCode(Vector(ColourFactory.newColour('R').get, ColourFactory.newColour('G').get,
    ColourFactory.newColour('B').get, ColourFactory.newColour('R').get, ColourFactory.newColour('O').get,
    ColourFactory.newColour('P').get))
  val responseHandler2 = new ResponseHandler(secretCode2)

  //Testing 4 peg secret code
  test("The response of a correct guess should be 4 black pegs") {
    val correctGuess = new Guess(Vector(ColourFactory.newColour('R').get,
                                        ColourFactory.newColour('G').get,
                                        ColourFactory.newColour('B').get,
                                        ColourFactory.newColour('R').get))

    val response: Response = responseHandler1.getResponse(correctGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])

    println(response)
    assert(response.pegs.length == secretCode1.length)
  }

  test("The response of a guess all but one correct and in the correct positions, there should be" +
   " X black pegs where X is the number of correct guesses and no white pegs") {
    val guess = new Guess(Vector(ColourFactory.newColour('R').get,
                                ColourFactory.newColour('G').get,
                                ColourFactory.newColour('B').get,
                                ColourFactory.newColour('Y').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
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
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
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
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
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
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
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
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 1)
    assert(whites.length == 2)
  }

  test("The response of a guess with 1 fully correct and 1 partially correct should be 1 black peg and 1 white.") {
    val guess = new Guess(Vector(ColourFactory.newColour('B').get,
      ColourFactory.newColour('Y').get,
      ColourFactory.newColour('P').get,
      ColourFactory.newColour('R').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.length == 1)
    assert(whites.length == 1)
  }
  test("The response of a guess with 0 fully correct and 4 partially correct should 4 white pegs.") {
    val guess = new Guess(Vector(ColourFactory.newColour('G').get,
                                ColourFactory.newColour('R').get,
                                ColourFactory.newColour('R').get,
                                ColourFactory.newColour('B').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.isEmpty)
    assert(whites.length == 4)
  }
  test("The response of a guess with no correct should no pegs.") {
    val guess = new Guess(Vector(ColourFactory.newColour('O').get,
                                ColourFactory.newColour('O').get,
                                ColourFactory.newColour('O').get,
                                ColourFactory.newColour('O').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.isEmpty)
    assert(whites.isEmpty)
  }
  test("The response of a guess with 0 fully correct and 1 partially correct should be 1 white peg.") {
    val guess = new Guess(Vector(ColourFactory.newColour('Y').get,
                                ColourFactory.newColour('B').get,
                                ColourFactory.newColour('Y').get,
                                ColourFactory.newColour('Y').get))

    val response = responseHandler1.getResponse(guess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])
    println(response)
    assert(blacks.isEmpty)
    assert(whites.length == 1)
  }

  //Testing 6 peg secret code
  test("The response of a correct guess should be 6 black pegs") {
    val correctGuess = new Guess(Vector(ColourFactory.newColour('R').get,
                                        ColourFactory.newColour('G').get,
                                        ColourFactory.newColour('B').get,
                                        ColourFactory.newColour('R').get,
                                        ColourFactory.newColour('O').get,
                                        ColourFactory.newColour('P').get))

    val response = responseHandler2.getResponse(correctGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])

    println(response)
    assert(response.pegs.length == secretCode2.length)
  }

  test("The response of no correct guess should be no pegs") {
    val incorrectGuess = new Guess(Vector(ColourFactory.newColour('Y').get,
                                          ColourFactory.newColour('Y').get,
                                          ColourFactory.newColour('Y').get,
                                          ColourFactory.newColour('Y').get,
                                          ColourFactory.newColour('Y').get,
                                          ColourFactory.newColour('Y').get))

    val response = responseHandler2.getResponse(incorrectGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])

    println(response)
    assert(blacks.isEmpty)
    assert(whites.isEmpty)
  }

  test("The response of 5 correct guess should be 5 black pegs") {
    val incorrectGuess = new Guess(Vector(ColourFactory.newColour('Y').get,
      ColourFactory.newColour('G').get,
      ColourFactory.newColour('B').get,
      ColourFactory.newColour('R').get,
      ColourFactory.newColour('O').get,
      ColourFactory.newColour('P').get))

    val response = responseHandler2.getResponse(incorrectGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])

    println(response)
    assert(blacks.length == 5)
  }

  test("The response of 4 correct guesses and 1 partial correct guess should be 4 black pegs and 1 white peg") {
    val incorrectGuess = new Guess(Vector(ColourFactory.newColour('P').get,
      ColourFactory.newColour('G').get,
      ColourFactory.newColour('B').get,
      ColourFactory.newColour('R').get,
      ColourFactory.newColour('O').get,
      ColourFactory.newColour('Y').get))

    val response = responseHandler2.getResponse(incorrectGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])

    println(response)
    assert(blacks.length == 4)
    assert(whites.length == 1)
  }

  test("The response of 6 partial correct guesses should be 6 white peg") {
    val incorrectGuess = new Guess(Vector(ColourFactory.newColour('P').get,
      ColourFactory.newColour('R').get,
      ColourFactory.newColour('G').get,
      ColourFactory.newColour('B').get,
      ColourFactory.newColour('R').get,
      ColourFactory.newColour('O').get))

    val response = responseHandler2.getResponse(incorrectGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])

    println(response)
    assert(blacks.isEmpty)
    assert(whites.length == 6)
  }

  test("The response of 3 correct guesses and 3 partial correct guesses should be 3 black pegs and 3 white pegs") {
    val incorrectGuess = new Guess(Vector(ColourFactory.newColour('R').get,
      ColourFactory.newColour('R').get,
      ColourFactory.newColour('B').get,
      ColourFactory.newColour('P').get,
      ColourFactory.newColour('O').get,
      ColourFactory.newColour('G').get))

    val response = responseHandler2.getResponse(incorrectGuess)
    val blacks = response.pegs.filter(rp => rp.isInstanceOf[Black])
    val whites = response.pegs.filter(rp => rp.isInstanceOf[White])

    println(response)
    assert(blacks.length == 3)
    assert(whites.length == 3)
  }

  //Testing for getResponsePeg

  test("Test that passing in true produces a black response peg") {
    assert(ResponseFactory.getResponsePeg(true).isInstanceOf[Black])
  }

  test("Test that passing in false produces a white response peg") {
    assert(ResponseFactory.getResponsePeg(false).isInstanceOf[White])
  }
}
