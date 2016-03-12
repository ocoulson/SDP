
package game

import pegs.ResponsePeg

/**
  * Created by Oliver Coulson on 11/03/2016.
  */
class Response(val pegs: Vector[ResponsePeg]) {
  override def toString: String = {
    val builder = new StringBuilder
    if(pegs.isEmpty) {
      builder.append("No pegs")
    } else {
      pegs.foreach(p => builder.append(p.name + " "))
    }
    builder.toString()
  }

}
