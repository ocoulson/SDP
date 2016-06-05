import annotation.tailrec
def queens(n: Int): List[List[Int]] = {
  def placeQueens(k: Int): List[List[Int]] =
    if (k == 0) List(List())
    else for {queens <- placeQueens(k - 1)
              column <- List.range(1, n + 1)
              if isSafe(column, queens, 1)} yield column :: queens
  placeQueens(n)
}

def isSafe(col: Int, queens: List[Int], delta: Int): Boolean = {
  queens match {
    case List() => true
    case head::tail => {
      col!=head &&
        math.abs(col-head)!= delta &&
        isSafe(col,tail,delta+1)
    }
  }
}

def factorial(n: Int): BigInt = {
  @tailrec
  def helper(count: Int, result: Int): BigInt = {
    if (count > n) result
    else helper(count+1, count * result)
  }
  helper(1,1)
}

factorial(14)