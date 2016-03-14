package game

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
object MastermindDriver {
  def main(args: Array[String]) {
    //Input argument 'true' for easy, 'false' for hard
    val g: Game = Factory.getInstance(false)
    g.runGames
  }
}
