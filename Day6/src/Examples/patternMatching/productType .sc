// A has a b of type B AND a c of type C
// Method f returns type F

def f(a: A): F =
  a match {
    case A(b,c) => ???

  }


case class A(b: B, c: C)

trait B
trait C
trait F