import atomicscala.src.com.atomicscala.AtomicTest._

class ClothesWasher(modelName:String, capacity:Double) {
  def this(modelName:String ) = this(modelName, capacity = 0)

  def this(capacity:Double) = this("", capacity)
}


val cw1 = new ClothesWasher("Hitachi")
val cw2 = new ClothesWasher(10)


//Using named parameters and defaults, the below class does what the
//above class and companion object did
class ClothesWasher2(modelName:String = "", capacity:Double = 0) {

}

