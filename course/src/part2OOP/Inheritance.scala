package part2OOP

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"

    def eat = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch = {
      super.eat
      println("crunch crunch")
    }

  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType = "domestic"
    override def eat = println("crunch crunch")
  }

  //  class Dog(dogType: String) extends Animal {
  //    override val creatureType = dogType
  //
  //    override def eat = println("crunch crunch")
  //  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (подстановка типов) (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // preventing overrides
  // 1 - use final on member of class
  // 2 - use final on the entire class
  // 3 - seal the class = extends classes in THIS FILE, prevent extension in other files


}
