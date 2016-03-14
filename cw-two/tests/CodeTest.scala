import game.{SecretCode, Guess, Code}
import handlers.ColourFactory
import org.scalatest.FunSuite

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
class CodeTest extends FunSuite {

  test("A guess that matches the secret code returns true") {
    val colour1 = ColourFactory.newColour('R').get
    val colour2 = ColourFactory.newColour('Y').get
    val colour3 = ColourFactory.newColour('G').get
    val colour4 = ColourFactory.newColour('R').get
    val guessVector = Vector(colour1, colour2, colour3, colour4)
    val guess = new Guess(guessVector)

    val colour5 = ColourFactory.newColour('R').get
    val colour6 = ColourFactory.newColour('Y').get
    val colour7 = ColourFactory.newColour('G').get
    val colour8 = ColourFactory.newColour('R').get
    val secretCodeVector = Vector(colour5, colour6, colour7, colour8)
    val secretCode = new SecretCode(secretCodeVector)

    assert(guess.equals(secretCode))
  }

  test("A guess that does not match the secret code returns false") {
    val colour1 = ColourFactory.newColour('B').get
    val colour2 = ColourFactory.newColour('Y').get
    val colour3 = ColourFactory.newColour('G').get
    val colour4 = ColourFactory.newColour('R').get
    val guessVector = Vector(colour1, colour2, colour3, colour4)
    val guess = new Guess(guessVector)

    val colour5 = ColourFactory.newColour('R').get
    val colour6 = ColourFactory.newColour('Y').get
    val colour7 = ColourFactory.newColour('G').get
    val colour8 = ColourFactory.newColour('R').get
    val secretCodeVector = Vector(colour5, colour6, colour7, colour8)
    val secretCode = new SecretCode(secretCodeVector)

    assert(!guess.equals(secretCode))
  }

  test("A guess that is not the same length as the secret code returns false") {
    val colour2 = ColourFactory.newColour('Y').get
    val colour3 = ColourFactory.newColour('G').get
    val colour4 = ColourFactory.newColour('R').get
    val guessVector = Vector(colour2, colour3, colour4)
    val guess = new Guess(guessVector)

    val colour5 = ColourFactory.newColour('R').get
    val colour6 = ColourFactory.newColour('Y').get
    val colour7 = ColourFactory.newColour('G').get
    val colour8 = ColourFactory.newColour('R').get
    val secretCodeVector = Vector(colour5, colour6, colour7, colour8)
    val secretCode = new SecretCode(secretCodeVector)

    assert(!guess.equals(secretCode))
  }

  test("Two identical guesses returns true from method isSameGuess") {
    val colour1 = ColourFactory.newColour('R').get
    val colour2 = ColourFactory.newColour('Y').get
    val colour3 = ColourFactory.newColour('G').get
    val colour4 = ColourFactory.newColour('R').get
    val guessVector = Vector(colour1, colour2, colour3, colour4)
    val guess = new Guess(guessVector)

    val colour5 = ColourFactory.newColour('R').get
    val colour6 = ColourFactory.newColour('Y').get
    val colour7 = ColourFactory.newColour('G').get
    val colour8 = ColourFactory.newColour('R').get
    val guess2Vector = Vector(colour5, colour6, colour7, colour8)
    val guess2 = new Guess(guess2Vector)

    assert(guess.equals(guess2))

  }

  test("Two non identical guesses returns false from method isSameGuess") {
    val colour1 = ColourFactory.newColour('R').get
    val colour2 = ColourFactory.newColour('Y').get
    val colour3 = ColourFactory.newColour('G').get
    val colour4 = ColourFactory.newColour('B').get
    val guessVector = Vector(colour1, colour2, colour3, colour4)
    val guess = new Guess(guessVector)

    val colour5 = ColourFactory.newColour('R').get
    val colour6 = ColourFactory.newColour('Y').get
    val colour7 = ColourFactory.newColour('G').get
    val colour8 = ColourFactory.newColour('R').get
    val guess2Vector = Vector(colour5, colour6, colour7, colour8)
    val guess2 = new Guess(guess2Vector)

    assert(!guess.equals(guess2))

  }

}
