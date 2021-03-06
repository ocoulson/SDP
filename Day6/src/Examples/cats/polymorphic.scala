package Examples.cats

/**
  * Created by Oliver Coulson on 12/02/2016.
  */
sealed trait Cat{
  def eat: Food
}
final case class Lion() extends Cat {
  def eat: Food = Antelope
}

final case class Tiger() extends Cat {
  def eat: Food = Frosties
}
final case class Panther() extends Cat {
  def eat: Food = Human
}
final case object Garfield extends Cat {
  def eat: Food = Lasagne
}
final case class DomesticCat(favouriteFood: String) extends Cat {
  def eat: Food = CatFood(favouriteFood)
}

sealed trait Food
final case object Lasagne extends Food
final case object Antelope extends Food
final case object Frosties extends Food
final case object Human extends Food
final case class CatFood(food: String) extends Food

