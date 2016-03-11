package game

import pegs.Colour
import com.softwaremill.macwire._

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
sealed trait Code {
  def length: Int = ???
}

final class Guess(val code: Vector[Colour]) extends Code {
  override def length = code.length
}

final class SecretCode(val code: Vector[Colour]) extends Code {
  override def length = code.length
}

object Code {
  def isGuessCorrect(code1: Guess, code2: SecretCode): Boolean = {
    if(code1.length != code2.length) false
    else {
        val zipped = code1.code.zip(code2.code)
        for(i <- zipped.indices) {
          if(zipped(i)._1.symbol != zipped(i)._2.symbol) return false
        }
        true
    }
  }
  def isSameGuess(code1: Guess, code2: Guess): Boolean = {
    val guess2Vector = code2.code
    //Method isGuessCorrect uses SecretCode, so new guess converted to SecretCode to avoid duplication.
    val secretCode = wire[SecretCode]
    isGuessCorrect(code1, secretCode)
  }
}

