def mapReduce(f: Int => Int, combine: (Int, Int) => Int, base: Int)(a: Int, b: Int) : Int = {
  if (a > b) base
  else combine(f(a), mapReduce(f, combine, base)(a+1, b))

}

def product(f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a, b)


product (x => x*x) (3, 7)

product (x => x) (1, 5)

product (x => x) (1, 10)


def factorial (a: Int): Int = {
  product (x => x) (1, a)
}

factorial(5)

factorial(10)


mapReduce(x => x, (x, y) => x * y, 1) (1, 5)

def sum(f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (x,y) => x + y, 0) (a, b)

sum(x => x) (1, 100)

