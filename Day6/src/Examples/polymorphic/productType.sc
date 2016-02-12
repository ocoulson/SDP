// if A hasa b of type B and a c of type C
// Method F will return an F, but uses B and C

case class A(b: B, c: C) {
  def F: F = ???
}

trait B
trait C
trait F


//a car has a p engine of type Petrol, an e engine of
//type Electric
//Method f will return one of type F
case class Car(p: Petrol, e: Electric) {
  def f: Hybrid = ???
}

trait Petrol
trait Electric
trait Hybrid