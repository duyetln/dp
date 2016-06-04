import scala.collection.mutable.ListBuffer

class Room(val name : String)
class Wall(val name : String)

class HauntedRoom extends Room("Haunted Room")
class EnchantedWall extends Wall("Enchanted Wall")

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

class HauntedMazeGame extends BasicMazeGame {
  val allowHolySpells = true
  override def makeRoom : HauntedRoom = new HauntedRoom
}

class EnchantedMazeGame extends BasicMazeGame {
  val allowMagicSpells = true
  override def makeWall : EnchantedWall = new EnchantedWall
}

class HybridMazeGame extends HauntedMazeGame {
  val twin = new EnchantedMazeGame
  def allowMagicSpells : Boolean = twin.allowMagicSpells
  override def makeWall : EnchantedWall = twin.makeWall
}

val hmg = new HybridMazeGame

println(hmg.allowHolySpells)
println(hmg.allowMagicSpells)
