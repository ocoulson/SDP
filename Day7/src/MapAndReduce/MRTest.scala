package MapAndReduce
import atomicscala.AtomicTest._
/**
  * Created by Oliver Coulson on 19/02/2016.
  */
object MRTest extends App{

  //1a
  println(1 + "a")
  val v = Vector(1, 2, 3, 4)

  var w =  v.map(n => (n * 11) + 10)
  w is Vector(21, 32, 43, 54)

  w = Vector(10)

  w is Vector(10)


  //1b - for each doesn't return anything, but map does
  println(1 + "b")
  v.foreach(n => (n*11) + 10) is Vector(21, 32, 43, 54)

  //1c
  println(1 + "c")
  var x = Vector[Int]()
  for (i <- v) {
    val newI = Vector((i*11) + 10)
    x = x ++ newI
  }

  x is Vector(21,32,43,54)

  //2
  println(2)
  val v1 = Vector(1, 2, 3, 4)
  v1.map(n => n + 1) is Vector(2, 3, 4, 5)

  //rewrite with for loop

  var v2 = Vector[Int]()
  for (i <- v1) {
    v2 = v2 ++ Vector(i+1)
  }

  v2 is Vector(2,3,4,5)


  //3
  println(3)

  val v3 = Vector(1, 10, 100, 1000)
  v3.reduce((sum, n) => sum + n) is 1111
  //Rewrite this with for loops

  var total = 0
  for (i <- v3) {
    total += i
  }

  total is 1111

  //4
  println(4)

  def sumIt(args: Int*): Int = {
    args.reduce((a, b) => a+b)
  }

  sumIt(1, 2, 3) is 6
  sumIt(45, 45, 45, 60) is 195
}


