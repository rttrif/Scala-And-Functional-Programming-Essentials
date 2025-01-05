package part1Basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 9 * 55 / 11)

  println(1 == x)

  var y = 2
  y += 3
  println(y)

  // Instructions vs Expressions
  //  Instructions tells DO something
  //  Expression evaluate VALUE

  //  IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // if it's expression, not instruction
  println(f"Condition Value: $aConditionValue")

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //  TRY NEVER USE WHILE LOOP IN SCALA, because while expression all return a Unit
  //  EVERYTHING IN SCALA IS AN EXPRESSION

  // Unit in Scala it's the same a  void in other languages
  //  Unit === void

  //  val aUnitValue = (aVariable = 3)
  //  println(aUnitValue)

  //  side effects: println(), while loop, reassigning


  //  CODE BLOCKS
  //  Code block is an expression
  //  THE VALUE OF THE BLOCK IS THE VALUE OF ITS LAST EXPRESSION

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)

}

