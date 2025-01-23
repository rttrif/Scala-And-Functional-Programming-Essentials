package part2OOP

object Enums extends App {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields or methods
    def openDocument(): Unit =
      if (this == READ) println("opening document ....")
      else println("reading not allowed")

  }

  val somePermissions: Permissions = Permissions.READ
  somePermissions.openDocument()

  // enums with constructor arguments
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }

  //  standard API of enums
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values // array of all possible values of the enum
  println(somePermissionsOrdinal)
  println(allPermissions)





}
