package Examples.recursiveData

/**
  * Created by Oliver Coulson on 12/02/2016.
  */
sealed trait IntList

case object End extends IntList
final case class Pair (head: Int, tail: IntList) extends IntList

object myApp extends App {

  val d = End
  val c = Pair(3, d)
  val b = Pair(2, c)
  val a = Pair(1, b)


  def sum(list: IntList): Int = {
    list match {
      case End => 0
      case Pair(head, tail) => head + sum(tail)
    }
  }

  print(sum(a))
}