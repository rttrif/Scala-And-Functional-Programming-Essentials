package part2OOP

object Objects extends App {
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  //  object - it's static like functionality
  // "static" / "class" - level functionality

  object Person {
    // object define like class, BUT it don't have parameters
    // when I define object, automatically I define: type + it's only instance

    val N_EYES = 2

    def canFlay: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // Pattern to write object and class together named - COMPANIONS


  println(Person.N_EYES)
  println(Person.canFlay)

  // Scala object = SINGLETON INSTANCE
  // Scala object -  singleton by definition
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person_1 = Person
  val person_2 = Person
  println(person_1 == person_2)

  val bobbie = Person.apply(mary, john)

  // Scala Application = Scala object with
  // def main(args: Array[String]): Unit 

}
