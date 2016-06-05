def sum(f: Int => Int)(a: Int, b:Int): Int = {
  def iter(a: Int, result: Int): Int = {
    if (a > b) result
    else {
      println(f(a))
      iter(a + 1, result + f(a))
    }
  }
  iter(a, 0)
}


def product(f:Int => Int)(a:Int, b:Int): Int = {
  def iter(a: Int, result:Int): Int = {
    if (a>b) result
    else iter(a+1, result*f(a))
  }
  iter(a, 1)
}

sum(x => x*2)(10, 20)
product(x => x*2)(10,20)

def factorial(n: Int): Int = {
  product(x => x)(1, n)
}

factorial(5)


def abstractSumProd(oper: (Int, Int) => Int)(f: Int => Int)(start: Int)(a: Int, b: Int): Int = {
  def iter(a: Int, result: Int): Int ={
    if (a > b) result
    else iter(a+1, oper(result, f(a)))
  }
  iter(a, start)
}

def sum2(f:Int => Int)(a: Int, b: Int) = abstractSumProd((x,y)=> x+y)(f)(0)(a,b)
def product2(f: Int => Int)(a: Int, b: Int) = abstractSumProd((x,y)=> x*y)(f)(1)(a,b)

sum2(x=>x)(1,10)