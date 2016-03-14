package game

import com.softwaremill.macwire._


/**
  * A Factory pattern class to return an instance of the GameStatus class.
  *
  * Created by Oliver Coulson and George Shiangoli on 10/03/2016.
  */
object Factory {
  /**
    * Creates and returns an instance of Game, using dependency injection
    *
    * @param b a flag to indicate whether or not the GameStatus should be an easy game with the code visible.
    * @return The instance of Game initialised with the boolean b
    */
  def getInstance(b: Boolean): Game = wire[GameStatus]
}
