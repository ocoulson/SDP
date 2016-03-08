import atomicscala.AtomicTest._

//1
val v = Vector(1, 2, 3, 4)

v.map(n => (n * 11) + 10) is Vector(21, 32, 43, 54)


//2
v.foreach(n => (n*11) + 10) is Vector(21, 32, 43, 54)

