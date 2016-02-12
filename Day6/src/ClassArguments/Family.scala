package ClassArguments

import atomicscala.src.com.atomicscala.AtomicTest._
/**
  * Created by Oliver Coulson on 12/02/2016.
  */
class Family(member: String*) {
  def familySize(): Int = {
    member.length
  }
}

class FlexibleFamily(mother: String, father: String, child: String*) {
  def familySize(): Int =
    child.length + 2
}

object TestArgs extends App {
  val family1 = new Family("Mum", "Dad", "Sally", "Dick")
  family1.familySize() is 4
  val family2 = new Family("Dad", "Mom", "Harry")
  family2.familySize() is 3

  val family3 = new FlexibleFamily("Mum", "Dad", "Sally", "Dick")
  family3.familySize() is 4
  val family4 = new FlexibleFamily("Dad", "Mom", "Harry")
  family4.familySize() is 3
}