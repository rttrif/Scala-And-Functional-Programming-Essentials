package part2OOP

object AbstractDataTypes extends App {

  // ABSTRACT

  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit

  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = "crunch crunch"


  }

  // TRAITS

  trait Carnivore(val name: String = "Default name in trait") {
    def eat(animal: Animal): Unit

    val preferredMeal: String = "fresh meat"

  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    def eat: Unit = println("nom nom nom")

    def eat(animal: Animal): Unit = println(f"I'm a Croc and I'm eating ${animal.creatureType}")
  }


  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)
  println(croc.name)

  // TRAITS VS ABSTRACT CLASSES
  // 1 - traits do not have constructor parameters, but in scala 3 this is possible
  // 2 - multiple traits may be inherited by the same class
  // 3 - trait = behavior, abstract class = "thing"




}
