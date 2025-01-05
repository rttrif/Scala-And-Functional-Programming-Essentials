package part1Basics

import scala.annotation.tailrec

object Recursion extends App {
  //  STACK AND TAIL RECURSION

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))

      val result = n * factorial(n - 1)

      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))

  //  println(factorial(50000)) // Get an error - StackOverflowError

  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION - use recursive  call as the LAST expression

    factHelper(n, 1)
  }

  println(anotherFactorial(50000))

  //  WHEN I NEED LOOPS, USE __TAIL__ RECURSION

}
