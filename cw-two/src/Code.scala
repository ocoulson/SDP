import pegs.Colour

/**
  * Created by George on 08/03/2016.
  */
sealed trait Code {
  def colourSeq: List[Colour]

  override def equals(other: Any): Boolean = {
    if(other.isInstanceOf[Code]) {
      val otherCode = other.asInstanceOf[Code]
      val zipped = colourSeq.zip(otherCode.colourSeq)
      zipped.foreach(tuple => {
        if(!tuple._1.name.equals(tuple._2.name)) false
      })
      true
    } else false
  }
}

final class Guess(input: List[String]) extends Code

final class SecretCode extends Code

