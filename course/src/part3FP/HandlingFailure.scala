package part3FP

import scala.util.{
  Failure,
  Random,
  Success,
  Try
}

object HandlingFailure extends App {

  // create success and failure
  val aSuccess = Success(2)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // IF design API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException())

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  // => for-comprehensions

  val host = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html> ... </html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  // shorthand version
  HttpService.getSafeConnection(host, port).
    flatMap(connection => connection.getSafe("/home")).
    foreach(renderHTML)

  // for-comprehension version
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)


















}
