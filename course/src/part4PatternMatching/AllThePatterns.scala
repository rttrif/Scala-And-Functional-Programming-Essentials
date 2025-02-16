package part4PatternMatching

object AllThePatterns extends App {
  // 1. Constants
  val x: Any = "Scala"
  val constants = x match
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"

  // 2. Match anything
  // 2.1 Wildcard
  val matchAnything = x match
    case _ =>

  // 2.2. Variable
  val matchVariable = x match
    case something => f"I've found $something"

  // 3. Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match
    case (1, 1) =>
    case (something, 2) => f"I've found $something"

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match
    case (_, (2, value)) =>
  // Pattern matches can be NESTED!


  // 4. Case classes - constructor pattern
  // Can be nested with case classes as well

  // 5. List patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // infix pattern

  // 6. Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match
    case list: List[Int] => // explicit type specifier
    case _ =>

  // 7. Name binding

  // 8. multi-patterns

  // 9. If guards
}



































