val x = 17
//x = 20
//the above doesn't work as vals are immutable

var temp = "ABC1234\""
println(temp)

temp = "DEF1234\""
print(temp)
//works cos vars are mutable

val temp1 = "ABC1234\""
//temp1 = "DEF1234\""
//again doesnt work cos val is immutable

val double = 15.56
println(double)

//Expressions

//1
var sky = "sunny"
var temperature: Double = 99
(sky == "sunny") && (temperature > 80)

//2
(sky == "sunny" || sky == "partly cloudy") &&
  (temperature > 80)

//3
(sky == "sunny" || sky == "partly cloudy") &&
  (temperature > 80 || temperature < 20)

//4

def fahrToCels(fahrenheit: Double): Double = {
  return ((fahrenheit - 32.0) * (5.0/9.0))
}

fahrToCels(80)

//5
def celsToFahr(celcius: Double): Double = {
  return (celcius * (9.0/5.0)) + 32.0
}

celsToFahr(100)



//Methods
//1
def getSquare(int: Int): Int = {
  return int * int
}

val a = getSquare(3)
assert(a == 9)

val b = getSquare(6)
assert(b == 36)

val c = getSquare(5)
assert(c == 25)

//2

def isArg1GreaterThanArg2(arg1: Double, arg2: Double): Boolean = {
  if (arg1 > arg2) {
    return true
  }
  else return false
}

val t1 = isArg1GreaterThanArg2(4.1, 4.12)
assert(t1 == false)

val t2 = isArg1GreaterThanArg2(2.1, 1.2)
assert(t2 == true)

//3
def manyTimesString(string: String, int: Int): String = {
  var temp = string
  var count = int
  while(count > 0) {
    temp = temp + temp
    count = count - 1
  }
  return temp
}

//Alternative to above, with for loop
val m1 = manyTimesString("abc", 3)
assert(m1 == "abcabcabc", "whoooooo")

object Test {

  def meth(s: String, i: Int): (String, Int) = {
    var str = s
    var j = i
    for (x <- 0 until j) {
      str += s;
    }
    j = 6
    (str, j)
  }
}
println(Test.meth("abc",3))






