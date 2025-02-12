package part3FP

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"

  val aTuple = Tuple2(2, "hello, Scala") // Tuple2[Int, String] = (Int, String)
  // val aTuple = (2, "hello, Scala") valid variant like in python

  println(aTuple._1) // _2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps: keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is syntax sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook.contains("Mary")) // return default value because Mary not exist in phonebook

  // add a pairing
  val newPairing = "Mary" -> 666
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.view.filter { case (key, _) => key.startsWith("J") }.toMap)
  // mapValues
  println(phonebook.view.mapValues(number => number * 10).toMap)

  // conversions to other collections

  println(phonebook.toList)
  println(List(("Daniel", 777)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
