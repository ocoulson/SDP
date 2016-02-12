//if A is a B or a C
//Function f which takes an A and returns an F


//Function is the first class citizen so this takes
//place in a function not in the subtypes B and C
def f(a: A): F =
  a match {
    case B() => ???
    case C() => ???
  }

trait A
case class B() extends A
case class C() extends A
trait F;
