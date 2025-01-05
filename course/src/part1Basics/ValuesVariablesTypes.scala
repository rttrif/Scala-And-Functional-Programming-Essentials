package part1Basics

object ValuesVariablesTypes extends App {

  val x: Int = 45
  println(x)

  // String concatenation
  println("My first variable in Scala: " + x)

  // String interpolation
  println(s"My first variable in Scala: $x")

  // f-string interpolation
  println(f"My first variable in Scala: $x")

  //  VALS ARE IMMUTABLE
  //  Types of val are optional
  //  COMPILER can infer types

  val y = 4555
  println(y)

  val myString: String = "hello"
  val myBool: Boolean = true
  val myChar: Char = 'd'
  val myShort: Short = 4511
  val myLong: Long = 6516515616515161565L
  val myFloat: Float = 2.0f
  val myDouble: Double = 2.1111

  //  VARIABLES

  var myVariable: Int = 55

  //  Variables can do side effects
  myVariable = 99 // side effects

  println(myVariable)



}
