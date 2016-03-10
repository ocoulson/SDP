package handlers

import pegs.{ResponsePeg, White, Black}
import com.softwaremill.macwire._

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
class ResponseHandler {
  //TODO Code to be completed after guess and secret code has been implemented.
}

object ResponseFactory {
  def getResponsePeg(black: Boolean): ResponsePeg = {
    if(black) wire[Black] else wire[White]
  }
}
