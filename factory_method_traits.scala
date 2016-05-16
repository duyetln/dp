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

class BombedRoom extends Room("Bombed Room")
class BombedWall extends Wall("Bombed Wall")
class BombedMaze extends Maze("Bombed Maze")

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

class BombedMazeGame extends MazeGame[BombedMaze, BombedRoom, BombedWall] {
  def makeMaze : BombedMaze = new BombedMaze
  def makeRoom : BombedRoom = new BombedRoom
  def makeWall : BombedWall = new BombedWall
}

class EnchantedMazeGame extends MazeGame[EnchantedMaze, EnchantedRoom, EnchantedWall] {
  def makeMaze : EnchantedMaze = new EnchantedMaze
  def makeRoom : EnchantedRoom = new EnchantedRoom
  def makeWall : EnchantedWall = new EnchantedWall
}

val bm = (new BombedMazeGame()).createMaze
val em = (new EnchantedMazeGame()).createMaze
