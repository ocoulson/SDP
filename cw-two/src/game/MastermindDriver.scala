package game

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
object MastermindDriver {
  def main(args: Array[String]) {
    //TODO: Get user input for easy/hard
    var g: Game = Factory.getInstance(classOf[Game], true)
    g.runGames
//    g = Factory.getInstance(classOf[Game], false)
//    g.runGames
  }
}
