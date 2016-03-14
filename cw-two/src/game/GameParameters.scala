package game

import java.io.{File, FileInputStream}
import java.util.Properties
import com.softwaremill.macwire._

/**
  * A class to hold the two parameters of the game, the length of the code and the number of guesses
  * the player has. These are actually stored in a configuration file called 'game.parameters'
  *
  * Created by Oliver Coulson and George Shiangoli on 14/03/2016.
  */
final class GameParameters {
  lazy val codeLength = parameters(0)
  lazy val numberOfGuesses = parameters(1)
  val properties: Properties = wire[Properties]
  val PATH: String = "." + File.separator +
                    "cw-two" + File.separator +
                    "src" + File.separator +
                    "game.properties"

  /**
    * Returns a Vector of the parameters taken from the game.properties file
    * @return the Vector of Ints containing codeLength and numberOfGuesses
    */
  def parameters: Vector[Int] = {
    properties.load(wire[FileInputStream])
    val length = properties.getProperty("codeLength").toInt
    val guesses = properties.getProperty("numberOfGuesses").toInt
    Vector(length, guesses)
  }
}
