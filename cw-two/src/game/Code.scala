package game

import pegs.Colour
import com.softwaremill.macwire._

/**
  * Code is a
  *
  * Created by Oliver Coulson and George Shiangoli on 10/03/2016.
  */

sealed abstract class Code(val code: Vector[Colour]) {
  def length = code.length

  override def toString: String = {
    val builder = new StringBuilder
    val rawString = code.map(c => c.symbol).toString()
    val substring = rawString.substring(rawString.indexOf('(') + 1, rawString.indexOf(')'))
    substring.foreach(c => if(c != ',' && c != ' ') builder.append(c))
    builder.toString()
  }

  override def equals(other: Any): Boolean = {
    if (!other.isInstanceOf[Code]) false
    else {
      val otherCode = other.asInstanceOf[Code]
      if(this.length != code.length) false
      else {
        val zipped = this.code.zip(otherCode.code)
        for(i <- zipped.indices) {
          if(zipped(i)._1.symbol != zipped(i)._2.symbol) return false
        }
        true
      }
    }
  }
}

final class Guess(code: Vector[Colour]) extends Code(code)

final class SecretCode(code: Vector[Colour]) extends Code(code)

