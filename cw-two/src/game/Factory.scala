package game

import com.softwaremill.macwire._


/**
  * Created by Oliver Coulson on 10/03/2016.
  */
object Factory {
  def getInstance(c: Class[_], b: Boolean): Game = wire[GameStatus]
}
