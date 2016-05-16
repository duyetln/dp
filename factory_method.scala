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

class BombedMazeGame extends MazeGame {
  def makeMaze : Maze = new BombedMaze
  def makeRoom : Room = new BombedRoom
  def makeWall : Wall = new BombedWall
}

class EnchantedMazeGame extends MazeGame {
  def makeMaze : Maze = new EnchantedMaze
  def makeRoom : Room = new EnchantedRoom
  def makeWall : Wall = new EnchantedWall
}

val bm = (new BombedMazeGame()).createMaze
val em = (new EnchantedMazeGame()).createMaze
