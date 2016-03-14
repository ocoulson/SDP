package game

import java.io.{File, FileInputStream}
import java.util.Properties
import com.softwaremill.macwire._

/**
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

  def parameters: Vector[Int] = {
    properties.load(wire[FileInputStream])
    val length = properties.getProperty("codeLength").toInt
    val guesses = properties.getProperty("numberOfGuesses").toInt
    Vector(length, guesses)
  }
}
