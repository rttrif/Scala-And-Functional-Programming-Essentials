package part2OOP

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // Advantage case classes
  // 1. Class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. Sensible toString
  // println(instance) = println(instance.toString) - syntactic sugar
  println(jim.toString)

  // 3. equals and hashCode implemented out of the box(OOTB)
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classes have hande copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)
  println(jim == jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // we don't use keyword new and use apply method form companion objects

  // 6. Case classes are serializable

  // 7. Case classes have extractor patterns = case classes can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }






}
