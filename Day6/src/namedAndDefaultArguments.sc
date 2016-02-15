import atomicscala.src.com.atomicscala.AtomicTest._

case class SimpleTime(hours: Int, minutes: Int) {

}
case class SimpleTime2(hours: Int, minutes: Int =  0) {

}

val t = new SimpleTime(hours=5, minutes=30)
t.hours is 5
t.minutes is 30

val t2 = new SimpleTime2(hours=10)
t2.hours is 10
t2.minutes is 0


case class Planet(name:String, description:String, moons: Int = 1) {
  def hasMoon(): Boolean = {
    if (moons != 0)
      return true
    else return false
  }
}


val p = new Planet("Mercury", "small and hot planet",0)
p.hasMoon is false

val earth = new Planet(moons = 1, name = "Earth",
  description = "a hospitable planet")
earth.hasMoon is true

class Item(name: String, price:Double) {
  def cost(grocery:Boolean = false, medication:Boolean = false, rate:Double = 0.1): Double = {
    if(grocery || medication) {
      return price
    } else {
      return price + (price*rate);
    }
  }
}

val flour = new Item(name="flour", 4)
flour.cost(grocery=true) is 4
val sunscreen = new Item(
  name="sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name="television", 500)
tv.cost(rate = 0.06) is 530

