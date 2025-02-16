package part3FP

import scala.util.Random

object Options extends App {

  // An OPTIONS - is a wrapper for a value that might be present or not

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // WORK with unsafe APIs
  def unsafeMethod(): String = null

  // val result = Some(null) // WRONG
  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - DO NOT USE THIS

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "100.11.93.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, is so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection(h, p)
  */
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  /*
     if (c != null)
       return  c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)
  // if (connectionStatus == null) println(None) else println(Some(connectionStatus.get))
  println(connectionStatus)
  /*
      if (status != null)
        println(status)
  */
  connectionStatus.foreach(println)

  // chained call
  config.get("host").
    flatMap(host => config.get("prot").
      flatMap(port => Connection(host, port)).
      map(connection => connection.connect)).
    foreach(println)

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)

}
