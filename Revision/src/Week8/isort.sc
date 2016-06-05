def isort(xs: List[Int]): List[Int] = {
  if(xs.isEmpty) Nil
  else insert1(xs.head, isort(xs.tail))
}

def insert(i: Int, list: List[Int]): List[Int] = {
  list match {
    case Nil => List(i)
    case x :: xs =>
      if (i < x) i :: list
      else x :: insert(i, xs)
  }
}
def insert1(i: Int, list: List[Int]): List[Int] = {
  list match {
    case Nil => List(i)
    case x :: xs =>
      if (i <= x) i :: list
      else x :: insert1(i, xs)
  }
}

isort(List(34,123,56,2,1,1))