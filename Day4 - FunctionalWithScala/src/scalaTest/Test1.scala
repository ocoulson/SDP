/**
  * Created by Oliver Coulson on 26/01/2016.
  */

//objects are singletons, there are 2 means of making a main method:
object Test1 {
  def main(args: Array[String]): Unit = {
    println("Hello")
  }

}

object test2 extends App {
  println("Fudgie")
}
