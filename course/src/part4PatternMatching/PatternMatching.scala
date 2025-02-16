package part4PatternMatching

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third ...."
    case _ => "something else" // _ = WILDCARD of default value
  }

  println(x)
  println(description)

  // Advanced cases use pattern matching
  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match
    case Person(n, a) if a < 21 => f"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) => f"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"

  println(greeting)
  /*
  1. cases are matched in order
  2. what if no cases match? -> MatchError
  3. type of the pattern match expression? -> Unified type of all types in all the cases
  4. Pattern Matching work really well with case classes
  */

  // 2. Pattern Matching on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  animal match {
    case Dog(someBreed) => println(f"Mathched a dog of the $someBreed breed")
  }

  // Match everything
  val isEven = x match
    case n if n % 2 == 0 => true
    case _ => false

}
