sealed trait A {
  def fun: String
}

final case class B() extends A {
  def fun: String = {
    "This is a B"
  }
}

final case class C() extends A {
  def fun: String =
    "This is a C"
}

//create an instance of trait A which is a B
val a: A = B()


//create an instance of trait A which is a C
val aa: A = C()

a.fun
aa.fun

