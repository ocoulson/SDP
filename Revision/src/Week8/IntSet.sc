trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet = {
    def helper(result: IntSet, other: IntSet): IntSet = {
      other match {
        case EmptySet() => result
        case NonEmptySet(elem, left, right) => {
          result.incl(elem)
          helper(result, left)
          helper(result, right)
        }
      }
      this match {
        case EmptySet() => result
        case NonEmptySet(elem, left, right) => {
          result.incl(elem)
          helper(result, left)
          helper(result, right)
        }
      }
    }
    helper(new EmptySet(),other)
  }
}

case class EmptySet() extends IntSet {
  override def contains (x: Int): Boolean = false
  override def incl(x: Int): IntSet = {
    new NonEmptySet(x, new EmptySet, new EmptySet)
  }
}

case class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet{
  override def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  override def incl(x: Int): IntSet = {
    if(x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  }


}