package Week8
import atomicscala.AtomicTest._

/**
  * Created by Oliver Coulson on 05/06/2016.
  */
sealed trait LinkedList[+A] {
  def length:Int = this match {
    case End => 0
    case Pair(head,tail) => 1 + tail.length
  }
  def contains(x: Int): Boolean = this match {
    case End => false
    case Pair(head,tail) => {
      if (x == head) true
      else tail.contains(x)
    }
  }

  def apply(n: Int): A = {
    if(n > this.length) throw new Exception
    def helper(i: Int): A = this match {
      case End => throw new Exception
      case Pair(head,tail)=> {
        if (i == n) head
        else helper(i+1)
      }
    }
    helper(0)
  }



}

final case object End extends LinkedList[Nothing]

final case class Pair[+A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object Main extends App {
  val example:LinkedList[Int] = Pair(1, Pair(2, Pair(3, End)))
  assert(example(0) == 1)
  assert(example(1) == 2)
  assert(example(2) == 3)
  assert(try {
    example(3)
    false
  } catch {
    case e: Exception => true
  })
}
