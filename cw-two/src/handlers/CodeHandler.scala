package handlers
import com.softwaremill.macwire._
import game.{SecretCode, Guess}
import pegs.Colour


/**
  * Created by Oliver Coulson on 10/03/2016.
  */
object CodeFactory {
  def generateSecretCode(pegNo: Int): SecretCode = {
    var code: Vector[Colour] = Vector[Colour]()
    for (i <- 0 until pegNo) {
      val colour = ColourFactory.generateRandomColour().get
      code = code :+ colour

    }
    val finalCode: Vector[Colour] = code
    val secretCode = wire[SecretCode]
    secretCode
  }

  def processGuess(guess: String): Guess = {???}
}
