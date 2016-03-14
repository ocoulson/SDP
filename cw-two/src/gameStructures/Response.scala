
package gameStructures

import pegs.ResponsePeg

/**
  * A wrapper class to hold a vector of ResponsePegs and provide a toString method for
  * it.
  *
  * Created by Oliver Coulson and George Shiangoli on 11/03/2016.
  */
class Response(val pegs: Vector[ResponsePeg]) {
  /**
    * Returns a simplified string based on the pegs vector.
    * For example if the vector is Vector(pegs.Black, pegs.White)
    * it would return 'Black White'
    * If the vector is empty, it returns the string 'No pegs'
    * @return the string representing the response
    */
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
