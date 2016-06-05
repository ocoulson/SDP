
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

abstract class IntTree {
  def contains(t: IntTree, v: Int): Boolean = {
    t match {
      case EmptyTree => false
      case Node(elem, left, right) => {
        if(elem == v) true
        else if(v<elem) contains(left,v)
        else contains(right,v)
      }

    }
  }

  def insert(t: IntTree, v: Int): IntTree = {
    t match {
      case EmptyTree => Node(v, EmptyTree, EmptyTree)
      case Node(elem, left, right) =>
        if (v == elem) t
        else if (v < elem) Node(elem, insert(left, v),right)
        else Node(elem,left,insert(right,v))

    }
  }
}