import scala.collection.mutable.ListBuffer

class Room(val name : String)
class Wall(val name : String)

class HauntedRoom extends Room("Haunted Room")
class EnchantedWall extends Wall("Enchanted Wall")

abstract class Maze {
  def addRoom(r : Room) {
    if (!(rooms contains r))
      rooms += r
  }

  def addWall(w : Wall) {
    if (!(walls contains w))
      walls += w
  }

  def setupRooms
  def setupWalls

  protected val rooms = new ListBuffer[Room]()
  protected val walls = new ListBuffer[Wall]()
}

class BasicMaze extends Maze {
  def setupRooms {
    addRoom(new Room("Basic Room"))
  }

  def setupWalls {
    addWall(new Wall("Basic Wall"))
  }
}

class HauntedMaze extends BasicMaze {
  override def setupRooms {
    addRoom(new HauntedRoom())
    addRoom(new HauntedRoom())
  }
}

class EnchantedMaze extends BasicMaze {
  override def setupWalls {
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
  }
}

class HybridMaze extends BasicMaze {
  override def setupRooms {
    addRoom(new HauntedRoom())
    addRoom(new HauntedRoom())
  }

  override def setupWalls {
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
  }
}

object MazeGame {
  def createMaze(t : String) : Maze = {
    var m : Maze = null
    if (t == "haunted")
      m = new HauntedMaze
    else if (t == "enchanted")
      m = new EnchantedMaze
    else if (t == "hybrid")
      m = new HybridMaze
    else
      m = new BasicMaze

    m.setupRooms
    m.setupWalls
    m
  }
}

val maze = MazeGame.createMaze("hybrid")
