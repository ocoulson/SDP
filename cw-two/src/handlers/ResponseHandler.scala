package handlers

import game.{Response, Code, Guess, SecretCode}
import pegs.{ResponsePeg, White, Black}
import com.softwaremill.macwire._

import scala.util.Random

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
class ResponseHandler(secretCode: SecretCode) {

  def getResponse(guess: Guess): Response = {
    if(guess.equals(secretCode)) {
      getResponseInstance(guess.code.map(c => ResponseFactory.getResponsePeg(true)))
    }
    else {
      val zipped = guess.code.zip(secretCode.code)
      val blacks: Vector[ResponsePeg] = zipped.filter(t => t._1 == t._2).map(t => ResponseFactory.getResponsePeg(true))

      val maybeWhiteLists = zipped.filter(t => t._1 != t._2).unzip

      val maybe1 = maybeWhiteLists._1.map(colour => colour.symbol)
      val maybe2 = maybeWhiteLists._2.map(colour => colour.symbol)

      val whites: Vector[ResponsePeg] = maybe1.intersect(maybe2).map(c => ResponseFactory.getResponsePeg(false))

      getResponseInstance(Random.shuffle(whites ++ blacks))

    }
  }
  private def getResponseInstance(input: Vector[ResponsePeg]): Response = {
    wire[Response]
  }
}

object ResponseFactory {
  def getResponsePeg(black: Boolean): ResponsePeg = {
    if(black) wire[Black] else wire[White]
  }
}
