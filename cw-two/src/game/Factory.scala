package game

import com.softwaremill.macwire._


/**
  * Created by Oliver Coulson on 10/03/2016.
  */
object Factory {
  def getInstance(b: Boolean): Game = wire[GameStatus]
}
