package part3FP

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  // "iterating"
  val combinations1 = numbers.flatMap(number => chars.map(character => "" + character + number))
  println(combinations1)

  val combinations2 = numbers.flatMap(number => chars.flatMap(character => colors.map(color => "" + character + number + "-" + color)))
  println(combinations2)

  // foreach
  list.foreach(println)

}
