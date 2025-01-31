package part3FP

object HOFsCurries extends App {

  val superFunction:(Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // higher order function (HOF)
  // map, flatMap, filter

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x:Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // nTimesBetter(f, n) = x => f(f(f...(x)))
  // increment10 = nTimesBetter(plusOne , 10) = x => plusOne(plusOne ....(x)) using lambda
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1) (f(x))

}
