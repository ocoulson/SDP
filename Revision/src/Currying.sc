


def f(x: Int)(y: Int) = x * y

def x = f(3)_

x(5)


def g(x: Int, y: Int) = x + y

def y = g(3,_:Int)

y(10)


