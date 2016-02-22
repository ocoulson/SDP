package TraitsAndInheritance

/**
  * Created by Oliver Coulson on 22/02/2016.
  */
sealed trait Colour {
  val R: Int;
  val G: Int;
  val B: Int;
  def isDark(): Boolean = {
    if ((R > 127 && G > 127) || (R > 127 && B > 127) || (G > 127 && B > 127)) true
    else false
  }
}

object Red extends Colour {
  override val R: Int = 255
  override val G: Int = 0
  override val B: Int = 0
}
object Yellow extends Colour {
  override val R: Int = 255
  override val G: Int = 255
  override val B: Int = 0
}
object Pink extends Colour {
  override val R: Int = 255
  override val G: Int = 102
  override val B: Int = 178
}

case class CustomColour(r: Int, g: Int, b: Int) extends Colour {
  override val R: Int = r
  override val G: Int = g
  override val B: Int = b

}
sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  val colour: Colour
}

case class Circle(radius: Double, colour: Colour) extends Shape {
  override def sides: Int = 1

  override def perimeter: Double = (radius * 2) * Math.PI

  override def area: Double = Math.PI * (radius * radius)

}

abstract class Rectangular(width: Double, height: Double, colour: Colour) extends Shape {
  override def sides: Int = 4

  override def perimeter: Double = (width * 2) + (height * 2)

  override def area: Double = (width * height)
}

case class Rectangle(width: Double, height: Double, colour: Colour) extends Rectangular(width, height, colour)


case class Square(side: Double, colour: Colour) extends Rectangular(side, side, colour)


object Draw {
  def apply(shape: Shape) = {
    var str: String = ""
    shape match {
      case _: Circle => str += "A circle of radius " + shape.asInstanceOf[Circle].radius + "cm"
      case _: Rectangle => str +=  "A rectangle of width " + shape.asInstanceOf[Rectangle].width + "cm and height " + shape.asInstanceOf[Rectangle].height + "cm"
      case _: Square => str +=  "A square of side " + shape.asInstanceOf[Square].side + "cm"
      case _ => str+= "Other"
    }
    val dark:Boolean = shape.colour.isDark()
    var isDark =""
    if (dark) isDark = "dark in colour"
    else isDark = "light in colour"

    shape.colour match {
      case Red => str += " and it is Red"
      case Yellow => str += " and it is Yellow"
      case Pink => str += " and it is Pink"
      case _ => str += " and it is " + isDark
    }

    println(str)
  }
}

object DrawApp extends App{
  Draw(Circle(10, Red))
  Draw(Rectangle(4,5, Yellow))
  Draw(Square(45, CustomColour(12, 141, 223)))
}

