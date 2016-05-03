//Recursive fibonacci sequence
def fib(n: Int): Int = {
  if (n < 2) 1
  else fib(n-1) + fib(n-2)
}

fib(5)

import scala.annotation._
//tail recursive fibonacci sequence
def fibTail(n: Int): BigInt = {
  @tailrec
  def fibHelper(x: Int, prev: BigInt = 1 , next: BigInt = 1): BigInt = {
    x match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(x-1, next, next+prev)
    }
  }
  fibHelper(n)
}

fibTail(5)

//Memoisation - storing values of a recursive call to avoid recomputing
//values unnecessarily

val memoFib = memo(fibTail)

def memo[X, Y] (f: X => Y): (X => Y) = {
  val cache = collection.mutable.Map[X,Y]()
  (x: X) => {

    //if the cache contains a value for key x, return it
    //otherwise compute it, store it in the cache, then return it.
    (cache.get(x)) match {
      case Some(y) => y
      case None =>
        val y = f(x)
        cache(x) = y
        y
    }
  }

}

//Another example using the memo function, this defines the function parameter
//for memo inline and takes a list and returns an Int (X=>Y)
val memoLength = memo {
  xs: List[Int] =>
    println("Computing")
    xs.length
}