package part2OOP

import part1Basics.{
  TestImportClass,
  TestImportClassSecond => AliasForImportClass
}


object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2025)

  // import package
  val testImport1 = new TestImportClass

  val testImport2 = new part1Basics.TestImportClass // this approach is - fully qualified name

  // packages in hierarchy via dot notation
  // matching folder structure

  // package object (specific for scala)
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val testImport3 = new AliasForImportClass

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef  - println, ???

}
