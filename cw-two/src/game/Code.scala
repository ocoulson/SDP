package game

import pegs.Colour

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
          if(zipped(i)._1.name != zipped(i)._2.name) return false
        }
        true
    }
  }
  def isSameGuess(code1: Guess, code2: Guess): Boolean = {
    val guess2Vector = code2.code
    //TODO: use code factory
    val secretCode = new SecretCode(guess2Vector)
    isGuessCorrect(code1, secretCode)
  }
}

