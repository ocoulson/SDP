package MapAndReduce
import atomicscala.AtomicTest._
/**
  * Created by Oliver Coulson on 19/02/2016.
  */
object MRTest extends App{

  //1a
  val v = Vector(1, 2, 3, 4)

  v.map(n => (n * 11) + 10) is Vector(21, 32, 43, 54)


  //1b - for each doesn't return anything, but map does
  v.foreach(n => (n*11) + 10) is Vector(21, 32, 43, 54)

  //1c
  for(i: Int <- a) {

  }

}
