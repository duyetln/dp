import scala.collection.mutable.ListBuffer

class Room(val name : String)
class Wall(val name : String)
class Maze(val name : String) {
  def addRoom(r : Room) {
    if (!(rooms contains r))
      rooms += r
  }

  def addWall(w : Wall) {
    if (!(walls contains w))
      walls += w
  }

  protected val rooms = new ListBuffer[Room]()
  protected val walls = new ListBuffer[Wall]()
}

class HauntedRoom extends Room("Haunted Room")
class HauntedWall extends Wall("Haunted Wall")
class HauntedMaze extends Maze("Haunted Maze")

class EnchantedRoom extends Room("Enchanted Room")
class EnchantedWall extends Wall("Enchanted Wall")
class EnchantedMaze extends Maze("Enchanted Maze")

trait MazeGame[M <: Maze, R <: Room, W <: Wall]  {
  def makeMaze : M
  def makeRoom : R
  def makeWall : W
  def createMaze : M = {
    val m = makeMaze

    m addRoom makeRoom
    m addRoom makeRoom
    m addWall makeWall
    m addWall makeWall
    m
  }
}

class HauntedMazeGame extends MazeGame[Maze, HauntedRoom, Wall] {
  val allowHolySpells = true
  def makeMaze : Maze = new Maze("Basic Maze")
  def makeWall : Wall = new Wall("Basic Wall")

  def makeRoom : HauntedRoom = new HauntedRoom
}

class EnchantedMazeGame extends MazeGame[Maze, Room, EnchantedWall] {
  val allowMagicSpells = true
  def makeMaze : Maze = new Maze("Basic Maze")
  def makeRoom : Room = new Room("Basic Room")

  def makeWall : EnchantedWall = new EnchantedWall
}

val hm = (new HauntedMazeGame()).createMaze
val em = (new EnchantedMazeGame()).createMaze
