def squareList(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => (y*y) :: squareList(ys)
}

def squareList2(xs: List[Int]): List[Int] = {
  xs map(y => y*y)
}

val l = List(1,2,3,5)

squareList(l)
squareList2(l)