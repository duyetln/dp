import scala.collection.mutable.ListBuffer

class Room(val name : String)
class Wall(val name : String)

class HauntedRoom extends Room("Haunted Room")
class EnchantedWall extends Wall("Enchanted Wall")

abstract class Maze(val name : String) {
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

class EnchantedMaze extends Maze {
  override def setupWalls {
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
    addWall(new EnchantedWall())
  }
}

class HybridMaze extends Maze {
  def setupRooms {
    addRoom(new HauntedRoom())
  }

  def setupWalls {
    addWall(new EnchantedWall())
  }
}


class MazeGame {
  def createMaze(type : String) : Maze = {
    var m : Maze
    if (type == "haunted")
      m = new HauntedMaze
    else if (type == "enchanted")
      m = new EnchantedMaze
    else if (type == "hybrid")
      m = new HybridMaze
    else
      m = new BasicMaze

    m.setupRooms
    m.setupWalls
    m
  }
}

val maze = (new MazeGame()).createMaze("hybrid")
