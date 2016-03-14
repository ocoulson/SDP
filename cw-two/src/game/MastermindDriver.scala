package game

import scala.io.StdIn

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
object MastermindDriver {
  def main(args: Array[String]) {
    println("Easy or hard - Input E for easy, or anything else for hard")
    print(":>")
    val input = StdIn.readLine().toUpperCase
    input match {
      case "E" => val g: Game = Factory.getInstance(true)
        g.runGames
      case _ => val g: Game = Factory.getInstance(false)
        g.runGames
    }
  }
}
