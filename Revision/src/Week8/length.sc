def length[A](list: List[A]): Int = list match {
  case Nil => 0
  case x :: xs => 1 + xs.length
}

def length1[A](list: List[A]): Int = {
  def findLength[A](acc: Int, list: List[A]): Int = list match{
    case Nil => acc
    case x :: xs => findLength(acc+1, xs)
  }

  findLength(0, list)
}

val l = List(12,123,5,53,234,1)

length(l)
length1(l)

