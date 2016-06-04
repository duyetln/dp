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

trait Haunted extends BasicMaze {
  override def setupRooms {
    addRoom(new HauntedRoom())
    addRoom(new HauntedRoom())
  }
}

trait Enchanted extends BasicMaze {
  override def setupWalls {
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
  }
}

class MazeGame {
  def createMaze(t : String) : Maze = {
    var m : Maze = null
    if (t == "haunted")
      m = new BasicMaze with Haunted
    else if (t == "enchanted")
      m = new BasicMaze with Enchanted
    else if (t == "hybrid")
      m = new BasicMaze with Haunted with Enchanted
    else
      m = new BasicMaze

    m.setupRooms
    m.setupWalls
    m
  }
}

val maze = (new MazeGame()).createMaze("hybrid")
