import atomicscala.src.com.atomicscala.AtomicTest._

class ClothesWasher(modelName:String, capacity:Double) {

}

object ClothesWasher {
  def apply(modelName:String) = new ClothesWasher(modelName, capacity = 0);
  def apply(capacity:Double) = new ClothesWasher(modelName = "", capacity);
}

val cw1 = ClothesWasher("Hitachi")
val cw2 = ClothesWasher(10)


//Using named parameters and defaults, the below class does what the
//above class and companion object did
class ClothesWasher2(modelName:String = "", capacity:Double = 0) {

}

