package part2OOP

object Generics extends App {

  class MyList[A] {
    // use type A
    // A - this is placeholder for type
    // This is generic class
    // A parameterize type of class

  }

  // I can define many parameters
  class MyMap[Key, Value]

  // Traits can be parameterized like a class

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // GENERIC METHOD

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // VARIANCE PROBLEM
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. yes - LIst[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // Can I do things like - animalList.add(new Dog) ??? - HARD QUESTION

  // 2.NO List of cats and list of animal are two different things = INVARIANCE
  class InvariantList[A]

  //  val invariantAnimalList: InvariantList[Animal] = InvariantList[Cat] - not work, get an error
  val invariantAnimalList: InvariantList[Animal] = InvariantList[Animal] // work  fine

  // 3. Hell, NO! = CONTRAVARIANCE
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // BOUNDED TYPES
  class Cage[A <: Animal](animal: A) // A it's subtype of Animal

  val cage = new Cage(new Dog)


//  class Car
//  val newCage = new Cage(new Car) // error

}



































