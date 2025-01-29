package part3FP

object AnonymousFunctions extends App {

  // OOP way
  val doubler = new Function[Int, Int]:
    override def apply(x: Int): Int = x * 2

  // Scala way
  // anonymous function (LAMBDA)
  val doublerScala = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params in lambda
  val justDoSomething: () => Int = () => 3
  println(justDoSomething) // function itself  part3FP.AnonymousFunctions$$$Lambda$29/0x000001fbd3029148@96532d6
  println(justDoSomething()) // call  3

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to  (x: Int) => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b






}
