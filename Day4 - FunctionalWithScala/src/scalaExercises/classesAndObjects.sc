import com.sun.tools.internal.jxc.gen.config.Classes

//1
object r extends Range(1, 10, 1) {

}
println(r)


object range2 extends Range(1,10, 2) {

}
println(range2)
//changing the step value determines how it iterates
//through the range

//2
var s1: String = "Sally"
var s2: String = "Sally"
if(s1.equals(s2)) {
  println("s1 and s2 are equal")

} else {
  println("s1 and s2 are not equal")
}

//Creating Classes
class Hippo {}
class Lion{}
class Tiger{}
class Monkey{}
class Giraffe{}
var h: Hippo = new Hippo
var l: Lion = new Lion
var t: Tiger = new Tiger
var m: Monkey = new Monkey
var g: Giraffe = new Giraffe
var l2 = new Lion()
var g2 = new Giraffe()
var g3 = new Giraffe()


//Methods inside classes
class Sailboat {
  def raise(): String = {
   return "Sails raised"
  }
  def lower(): String = {
   return "Sails lowered"
  }
  def signal(): String = {
    val f = new Flare
    f.light
  }
}

class Motorboat {
  def start(): String = {
    return "Motor on"
  }
  def stop(): String = {
    return "Motor off"
  }
  def signal(): String = {
    val f = new Flare
    return f.light
  }
}

val sailboat = new Sailboat
val r1 = sailboat.raise()
assert(r1 == "Sails raised", "Expected \"Sails raised\", Got"+r1)
val r2 = sailboat.lower()
assert(r2 == "Sails lowered", "Expected Sails lowered, Got " + r2)
val motorboat = new Motorboat
val s11 = motorboat.start()
assert(s11 == "Motor on", "Expected Motor on, Got " + s11)
val s21 = motorboat.stop()
assert(s21 == "Motor off", "Expected Motor off, Got " + s21)

class Flare {
  def light(): String = {
    return "Flare used!"
  }
}
val flare = new Flare
val f1 = flare.light
assert(f1 == "Flare used!", "Expected Flare used!, Got " + f1)
val sailboat2 = new Sailboat
val signal = sailboat2.signal()
assert(signal == "Flare used!", "Expected Flare used! Got " + signal)
val motorboat2 = new Motorboat
val flare2 = motorboat2.signal()
assert(flare2 == "Flare used!", "Expected Flare used!, Got " + flare2)