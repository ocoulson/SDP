val l = List(List(104,34,132),List(12,53),List(324,55))

def flatten[A](xss: List[List[A]]): List[A] = {
  xss match {
    case Nil => List()
    case hd :: tl =>
      hd ::: flatten(tl)
  }
}

def flatten2[A](xss: List[List[A]]): List[A] = {
  for {xs <- xss
       x <- xs} yield x
}


flatten(l)
flatten2(l)