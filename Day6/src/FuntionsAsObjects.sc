import atomicscala.src.com.atomicscala.AtomicTest._
def explicitSet2(a:Vector[Double]): String = {
  var str = ""
  val set: Set[Double] = a.toSet
  set.foreach(d => str = str + d.toInt + ",")

  str
}

val str = explicitSet2(Vector(1,2,3,3,4,2))

str is "1,2,3,4,"

//Assign a lambda function literal to a variable
val dogYears = {x:Int => x *7}


dogYears(10) is 70


//Alternatively define an anonymous function
val dogYears2 = new Function[Int, Int] {
  override def apply(v1: Int): Int = v1 * 7
}

dogYears2(10) is 70


var s = ""
val v = Vector(1, 5, 7, 8)
v.foreach(v => s += dogYears(v) + " ")
s is "7 35 49 56 "

val square = new Function[Int, Int] {
  override def apply(v1: Int): Int = v1 * v1
}

var s2 = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(n => s2 += square(n) + " ")
s2 is "1 4 25 9 49 "
