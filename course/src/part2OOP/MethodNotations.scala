package part2OOP

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = f"${this.name} is hanging out with ${person.name}"

    def unary_! : String = f"${this.name} what the heck!?"

    def isAlive: Boolean = true

    def apply(): String = f"Hi, my naame is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // infix notation = operator notation (it's syntactic sugar)
  println(mary likes "Inception") // equivalent dot notation above

  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)

  // ALL OPERATORS ARE METHODS

  // prefix notation = it's all about unary operators
  val x = -1 // equivalent with 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // available only for methods without parameters
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

}
