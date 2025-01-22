package part2OOP

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("haahahhahahahah")
  }

  println(funnyAnimal.getClass) // get: class part2OOP.AnonymousClasses$$anon$1

  /*
  Equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
     override def eat: Unit = println("haahahhahahahah")
  }
   val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  */

  class Person(name: String) {
    def sayHi: Unit = println(f"Hi, my name is ${name}, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(f"Hi, my name is jim, how can I be of service?")
  }
}
