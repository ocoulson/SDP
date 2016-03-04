package Generics


import atomicscala.AtomicTest._

/**
  * Created by Oliver Coulson on 25/02/2016.
  */
sealed trait LinkedList[+T <: LinkedList[T]] {
  var length: Int
  def size: Int
  def contains [C >: T] (t: C): Boolean
  def apply(n: Int): Result[T]
}

case object End extends LinkedList[Nothing] {
  var length = 0
  def size: Int = 0
  def contains[C >: Nothing] (t: C): Boolean = false
  def apply(n: Int): Result[Nothing] = Failure[Nothing]("Fail")
}

final case class Pair[+T <: LinkedList[T]](head: T, tail: LinkedList[T]) extends LinkedList[T] {
  var length = size

  def size: Int = {
    if (tail.equals(End)) 1
    else 1 + tail.size
  }
  def contains[C >: T] (t: C): Boolean = {
    if (!head.equals(t) && tail.equals(End)) false
    else if (head.equals(t)) true
    else tail.contains(t)
  }
  def apply(n: Int) : Result[T] ={
    var index = 0
    if (n >= length) {
      Failure[T]("Index out of bounds")
    }
    if (n == index) Success[T](head)
    else {
      index = index + 1
      tail.apply(n)
    }
  }
}

sealed trait Result[+A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

//object Main extends App {
//  val myList = Pair(1, Pair(2, Pair(3, End)))
//
//  myList.size is 4
//
//  val example = Pair(1, Pair(2, Pair(3, End)))
//  assert(example.length == 3)
//  assert(example.tail.length == 2)
//  assert(End.length == 0)
//
//  assert(example.contains(3) == true)
//  assert(example.contains(4) == false)
//  assert(example.contains(0) == false)
//  // This should not compile
//  //example.contains("not an Int")
//
//
//  assert(example(0) == 1)
//  assert(example(1) == 2)
//  assert(example(2) == 3)
//  assert(try {
//    example(3)
//    false
//  } catch {
//    case e: Exception => true
//  })
//}