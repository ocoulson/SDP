import atomicscala.src.com.atomicscala.AtomicTest._
//1
val v1 = Vector("String vector", "moo")
val v2 = Vector(12.1)
val v3 = Vector(12)
val v5 = Vector("another string vector")

//2
val v4 = Vector[Vector[String]](v1, v5)

val v6 = Vector(v1,v2,v3,v4,v5)


//3

val stringVector = Vector("Hello, ", "my ", "name ", "is ", "arseface")
var stringHolder =""
stringVector.foreach { string =>
  println(string)
  stringHolder += string
}

for(string <- stringVector) {
  println(string)
}

stringHolder is "Hello, my name is arseface"

//4

val intVector = Vector(1,2,3,5,6)
val doubleVector = Vector(12.3,43.4,345.7)

intVector.sum
doubleVector.sum

intVector.max
doubleVector.max

intVector.min
doubleVector.min

//5

val myVector1 = Vector(1,2,3,4,5,6)
val myVector2 = Vector(1,2,3,4,5,6)

myVector1 is myVector2
