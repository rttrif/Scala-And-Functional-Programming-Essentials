package part2OOP

object OOPBasics extends App {
  val person = new Person("John", 27)
  println(person.age)
  println(person.field)
  person.greet("Daniel")
  person.greet()


  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Greate Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter(10)
  counter.inc.print



}

class Person(name: String, val age: Int) { // constructor
  // class body
  val field = 2

  // method
  def greet(name: String): Unit = println(f"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(f"Hi, I am $name")

  // multiple constructors or overloading constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")

}
// class parameters are NOT FIELDS
// var or val definitions inside class body are field
// When we instantiate class all code block will be evaluated

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}

class Counter(val count: Int) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  } // immutability

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  //  def inc(n: Int) = new Counter(count + 1)
  //
  //  def dec(n: Int) = new Counter(count - 1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n + 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}




