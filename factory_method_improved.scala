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

abstract class MazeGame {
  def makeMaze : Maze
  def makeRoom : Room
  def makeWall : Wall
  def createMaze : Maze = {
    val m = makeMaze

    m addRoom makeRoom
    m addRoom makeRoom
    m addWall makeWall
    m addWall makeWall
    m
  }
}

class BasicMazeGame extends MazeGame {
  def makeMaze : Maze = new Maze("Basic Maze")
  def makeRoom : Room = new Room("Basic Room")
  def makeWall : Wall = new Wall("Basic Wall")
}

trait Haunted extends BasicMazeGame {
  val allowHolySpells = true
  override def makeRoom : HauntedRoom = new HauntedRoom
}

trait Enchanted extends BasicMazeGame {
  val allowMagicSpells = true
  override def makeWall : EnchantedWall = new EnchantedWall
}

val hmg = new BasicMazeGame with Haunted
val emg = new BasicMazeGame with Enchanted
val hbmg = new BasicMazeGame with Haunted with Enchanted

println(hbmg.allowHolySpells)
println(hbmg.allowMagicSpells)
