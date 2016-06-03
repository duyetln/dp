class Room:
    def __init__(self, name="Room"):
        self.name = name

class Wall:
    def __init__(self, name="Wall"):
        self.name = name

class Maze:
    rooms = []
    walls = []

    def __init__(self, name="Maze"):
        self.name = name

    def addRoom(self, r):
        if r not in self.rooms:
            self.rooms.append(r)

    def addWall(self, w):
        if w not in self.walls:
            self.walls.append(w)


class HauntedRoom(Room):
    def __new__(self):
        return Room.__new__("Haunted Room")
class HauntedWall(Wall):
    def __new__(self):
        return Wall.__new__("Haunted Wall")
class HauntedMaze(Maze):
    def __new__(self):
        return Maze.__new__("Haunted Maze")


class EnchantedRoom(Room):
    def __new__(self):
        return Room.__new__("Enchanted Room")
class EnchantedWall(Wall):
    def __new__(self):
        return Wall.__init__("Enchanted Wall")
class EnchantedMaze(Maze):
    def __new__(self):
        return Maze.__new__("Enchanted Maze")


class MazeGame:

    def __init__(self):
        pass

    def makeMaze(self):
        return Maze()
    def makeRoom(self):
        return Room()
    def makeWall(self):
        return Wall()

    def createMaze(self):
        m = self.makeMaze()
        m.addRoom(self.makeRoom())
        m.addRoom(self.makeRoom())
        m.addWall(self.makeWall())
        m.addWall(self.makeWall())

class BasicMazeGame(MazeGame):
    def makeMaze(self):
        return Maze.__init__("Basic Maze")
    def makeRoom(self):
        return Maze.__init__("Basic Room")
    def makeWall(self):
        return Maze.__init__("Basic Wall")
  

class HauntedMazeGame(MazeGame):
    allowHolySpells = True

    def makeRoom(self):
        return HauntedRoom()


class EnchantedMazeGame(MazeGame):

    allowMagicSpells = True

    def makeWall(self):
        return EnchantedWall()



# Factory Method hybridization solution:
class CustomMazeGame(BasicMazeGame):
   allowHolySpells = True
   allowMagicSpells = True
   
   def makeRoom(self):
       return HauntedRoom()
   
   def makeWall(self):
       return EnchantedWall()


hmg = HauntedMazeGame()
emg = EnchantedMazeGame()
hymg = CustomMazeGame(roomType="haunted", wallType="enchanted", spellsAllowed="both")

