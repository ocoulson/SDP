sealed trait A {
  def fun: String = "I am an A"
}

final case class B() extends A {
  override def fun: String = {
    "This is a B"
  }
}

final case class C() extends A {
  override def fun: String =
    "This is a C"
}

//If fun has a value in the trait, we have a clash
//so to specify our own version of fun in B or C
//we use the keyword override


//create an instance of trait A which is a B
val a: A = B()


//create an instance of trait A which is a C
val aa: A = C()

a.fun
aa.fun
