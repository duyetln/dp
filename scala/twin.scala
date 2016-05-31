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

class EnchantedWall extends Wall("Enchanted Wall")

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
  var allowHolySpells = true
  override def makeRoom : HauntedRoom = new HauntedRoom
}

class EnchantedMazeGame extends BasicMazeGame {
  var allowMagicSpells = true
  override def makeWall : EnchantedWall = new EnchantedWall
}

class TwinHauntedMazeGame extends HauntedMazeGame {
  var twin : EnchantedMazeGame = null;
  def allowMagicSpells : Boolean = twin.allowMagicSpells
  override def makeWall : EnchantedWall = twin.makeWall
}

class TwinEnchantedMazeGame extends EnchantedMazeGame {
  var twin : HauntedMazeGame = null;
  def allowHolySpells : Boolean = twin.allowHolySpells
  override def makeRoom : HauntedRoom = twin.makeRoom
}

val thmg = new TwinHauntedMazeGame
val temg = new TwinEnchantedMazeGame

thmg.twin = temg
temg.twin = thmg

println(thmg.allowHolySpells)
println(thmg.allowMagicSpells)
println(temg.allowHolySpells)
println(temg.allowMagicSpells)
