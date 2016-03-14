package handlers
import com.softwaremill.macwire._
import gameStructures.{SecretCode, Guess}
import pegs.Colour


/**
  * CodeFactory uses the factory pattern, returns either a randomly generated SecretCode or a Guess
  * based on user input.
  * The length of a Guess/SecretCode is held as a field and set on construction.
  *
  * Created by Oliver Coulson and George Shiangoli on 10/03/2016.
  */
class CodeFactory(val pegNo: Int) {
  /**
    * Generates the secret code each run of the game.
 *
    * @return a SecretCode object of length 'pegNo'
    */
  def generateSecretCode: SecretCode = {
    val finalCode: Vector[Colour] = buildRandomVector(Vector[Colour]())
    val secretCode = wire[SecretCode]
    secretCode
  }

  /**
    * A recursive method to build a random vector of colours to be held in the SecretCode object
    *
    * @param vector the vector to be built (initially empty)
    * @return a full vector of random colours
    */
  private def buildRandomVector(vector: Vector[Colour]): Vector[Colour] = {
    if(vector.length < pegNo) {
      val newVector: Vector[Colour] = vector ++ Vector(ColourFactory.generateRandomColour().get)
      buildRandomVector(newVector)
    } else {
      vector
    }
  }

  /**
    * Given a string as user input, and providing that the input is valid, this returns a Guess
    * holding a vector of colours matching the user input, wrapped in an Option. If the input is
    * invalid, i.e. wrong length or includes a non-recognised character, it returns None
    *
    * @param guess the user input String
    * @return an Option containing either a Guess object or None.
    */
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
