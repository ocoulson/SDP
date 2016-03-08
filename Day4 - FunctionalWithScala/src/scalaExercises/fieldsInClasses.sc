
import atomicscala.src.com.atomicscala.AtomicTest._

class Cup {
  var percentFull = 0
  val max = 100
  val min = 0
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    } else if (percentFull < min) {
      percentFull = min
    }
    percentFull // Return this value
  }

  def set(i: Int) = {
    percentFull = i;
  }
  def get(): Int ={
    return percentFull
  }
}

val cup = new Cup
cup.add(45) is 45
cup.add(-15) is 30
cup.add(-50) is -20 //now fails
cup.add(-9) is 1 //now fails
cup.add(-2) is 0

cup.percentFull = 90
cup.percentFull is 90

cup.set(56)
cup.get() is 56

