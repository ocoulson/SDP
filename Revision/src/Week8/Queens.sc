def queens(n: Int): List[List[Int]] = {
  def placeQueens(k: Int): List[List[Int]] = {
    if (k == 0) List(List())
    else for {queens <- placeQueens(k - 1)
              column <- List.range(1,n+1)
              if isSafe(column, queens, 1)} yield column :: queens

  }
  placeQueens(n)
}

def isSafe(col: Int, queens:List[Int], delta: Int): Boolean = {
  queens match {
    case Nil => true
    case List() => true
    case hd :: tl =>
      hd != col &&
      Math.abs(hd-col) != delta &&
      isSafe(col, tl, delta+1)

  }
}

queens(8)

def isSafeOllie(col: Int,queens:List[Int],delta:Int): Boolean = {
  queens match {
    case List() => true
    case hd::tl =>
      hd != col &&
      math.abs(hd-col) != 2
  }
}