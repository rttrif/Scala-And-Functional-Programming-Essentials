package part2OOP

object Exceptions extends App {

  val x: String = null
  //  println(x.length) // this will crash with a NullPointerException

  // 1. throwing  exceptions

  //  throw new NullPointerException // this is expression

  // throwable classes extend the Throwable class.
  // Exceptions and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptons: Boolean): Int =
    if (withExceptons) throw new RuntimeException("No int for you!!!")
    else 42


  try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // this block is optional
    // does not influence the return type of this expression
    // use finally only for side effects (logging for example)
    println("finally")
  }

  // 3. how to define own exception
  class MyException extends Exception
  val exception = new MyException

//  throw exception
}
