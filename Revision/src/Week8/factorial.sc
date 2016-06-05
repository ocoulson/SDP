def factorial(n: Int): Int = {
  if (n==0) 1
  else n * factorial(n-1)
}

factorial(5)

def factorialTail(n: Int): Int = {
  def helper(acc: Int, n: Int): Int = {
    if (n == 0) acc
    else n * helper(acc, n-1)
  }
  helper(1,n)
}

factorialTail(5)