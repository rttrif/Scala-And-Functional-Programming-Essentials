package part3FP

object WhatAFunction extends App {

  // FP: functions are "first-class" citizens, i.e. work with functions like any other values
  // JVM was built for Java, an OO language: objects (instances of classes) are "first-class" citizens

  // DREAM: Use function as first class elements: object of classes
  // problem: oop (scala works on JVM)

  // function like class (class that work like function)

  // We want to work with functions:
  //  - pass functions as parameters
  //  - use functions as values

  val doubler = new MyFunction[Int, Int]:
    override def apply(element: Int): Int = element * 2

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int]:
    override def apply(string: String): Int = string.toInt

  println(stringToIntConverter("3") + 4)

  // Function types: Function2[A, B, R] === (A,B) => R (R = result)

  // ALL SCALA FUNCTIONS ARE OBJECTS - it's instances of class Function1,  Function2 ... ect.
  // functions traits, up to 22 params

  def concatenator: (String, String) => String = new Function2[String, String, String]:
    override def apply(a: String, b: String): String = a + b

  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val supperAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = supperAdder(3)
  println(adder3(4))
  println(supperAdder(3)(4)) // curried function

}

trait MyFunction[A, B] {
  def apply(element: A): B
}