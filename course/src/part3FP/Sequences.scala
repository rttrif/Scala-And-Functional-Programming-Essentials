package part3FP

import scala.util.Random

object Sequences extends App {

  /*
  SEQUENCES
    A (very) general interface for data structures that
      - have a well defined order
      - can be indexed

    Supports various operations from the box
  */

  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7)) // concatenation
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => print("Hello-"))

  /*
  LIST

  A LinerSeq - immutable linked list
    - head, tail, isEmpty method are fast: O(1)
    - most operations are O(n): lenght, reverse

  Sealed - has two subtypes:
    - object Nil - it's empty list
    - class ::
  */

  val aList = List(1, 2, 3)
  val prepended1 = 42 :: aList
  println(prepended1)

  val prepended2 = 42 +: aList :+ 89
  println(prepended2)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))


  /*
  ARRAYS
    The equivalent of simple Java arrays
      - can be manually constructed with predefined lengths
      - can be mutated (updated in place)
      - are interoperable with Java's T[] arrays
      - indexing is fast
  */
  val numbers = Array(1, 2, 3, 4, 5)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  /*
  VECTORS
    The default implementation for immutable sequences
      - effectively constant indexed read and write: O(log32(n))
      - fast element addition: append \ prepend
      - implemented as a fixed-branched trie (branch factor 32)
      - good performance for large sizes

  */
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs list

  val maxRuns = 1000
  val maxCapacity = 10000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  // keeps reference to tail
  // updating an elements in the middle of takes long
  val numbersList = (1 to maxCapacity).toList

  // depth of the tree is small
  // need to replace an entire 32-elemenst chunk
  val numbersVectors = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVectors))



}
