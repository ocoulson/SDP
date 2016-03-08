import atomicscala.src.com.atomicscala.AtomicTest._

class Tea(name: String = "Earl Grey", decaf:Boolean =false, sugar: Boolean = false, milk: Boolean = false) {
  def describe(): String = {
      var output = name
      if (decaf) {
          output = output + " decaf"
      }
      if (milk) {
          output = output + " + milk"
      }
      if (sugar) {
          output = output + " + sugar"
      }
      return output
  }
  def calories(): Int = {
    var output = 0;
    if(milk) {
      output += 100
    }
    if(sugar) {
      output += 16
    }
    return output
  }
}

object TeaScript extends App {
  val tea = new Tea
  tea.describe is "Earl Grey"
  tea.calories is 0
  val lemonZinger = new Tea(decaf = true, name="Lemon Zinger")
  lemonZinger.describe is "Lemon Zinger decaf"
  lemonZinger.calories is 0
  val sweetGreen = new Tea( name="Jasmine Green", sugar=true)
  sweetGreen.describe is "Jasmine Green + sugar"
  sweetGreen.calories is 16
  val teaLatte = new Tea(sugar=true, milk=true)
  teaLatte.describe is "Earl Grey + milk + sugar"
  teaLatte.calories is 116
}