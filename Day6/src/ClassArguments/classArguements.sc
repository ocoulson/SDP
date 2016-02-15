import atomicscala.src.com.atomicscala.AtomicTest._

def squareThem(roots: Int*): Int = {
  var total = 0
  roots.foreach(int => total += (int * int))
  return total
}

squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21