package handlers
import com.softwaremill.macwire._
import game.{SecretCode, Guess}
import pegs.Colour


/**
  * Created by Oliver Coulson on 10/03/2016.
  */
class CodeFactory(pegNo: Int) {

  def generateSecretCode: SecretCode = {
    val finalCode: Vector[Colour] = buildRandomVector
    val secretCode = wire[SecretCode]
    secretCode
  }
  private def buildRandomVector: Vector[Colour] = {
    var code: Vector[Colour] = Vector[Colour]()
    for (i <- 0 until pegNo) {
      val colour = ColourFactory.generateRandomColour().get
      code = code :+ colour
    }
    code
  }
  def processGuess(guess: String): Option[Guess] = {
    if (guess.length != pegNo) None
    else {
      val colourHandler = wire[ColourHandler]
      val symbols = colourHandler.rawNames.map(_.charAt(0).toUpper)
      guess.foreach(s => if(!symbols.contains(s)) return None)
      val colourVector: Vector[Colour] = guess.map(c => ColourFactory.newColour(c).get).toVector
      Some(wire[Guess])
    }
  }
}
