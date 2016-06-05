import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.Map

def fib(n: Int): Int = {
  if ((n == 1) || (n==2)) 1
  else (fib(n-1) + fib(n-2))
}
fib(1)
fib(2)
fib(3)
fib(4)
fib(5)
fib(6)
fib(7)
fib(8)

def fibMemo(n: Int): BigInt = {
  def helper(j: Int, acc: Map[Int, BigInt]): BigInt = {
    if (acc.contains(n)) acc.get(n).get
    else if ((j == 1)||(j==2)) {
      acc.put(j, 1)
      1
    } else {
      acc.put(j, helper(j-1, acc) + helper(j-2, acc))
      acc.get(j).get
    }
  }
  helper(n,new mutable.HashMap[Int, BigInt])
}

fibMemo(8)
def fibPete(n: Int): Int = {
  @tailrec
  def loop(k: Int, acc: Map[Int, Int]): Int = {
    if (k == n) {
      acc.get(k-1).get + acc.get(k-2).get
    } else {
      acc.put(k, acc.get(k-1).get + acc.get(k-2).get)
      loop(k+1, acc)
    }
  }
  var acc = new mutable.HashMap[Int, Int]()
  acc.put(1,1)
  acc.put(2,1)
  if (n == 1 || n == 2) 1
  else loop(3, acc)
}
fibPete(20)

def sum(f: Int => Int)(start: Int, end: Int) = {
  def h(ac: Int, start: Int): Int = {
    if (start > end) ac
    else {
      val temp = ac + f(start)
      println(temp)
      h(temp, start+1)
    }
  }
  h(0,start)
}

sum(x => x*3)(10, 15)