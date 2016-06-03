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
class CustomMazeGame:
    def __init__(self, mazeType=None, roomType=None, wallType=None, spellsAllowed=None):
        self.mazeType = mazeType
        self.roomType = roomType
        self.wallType = wallType

        if spellsAllowed == "haunted":
            self.allowHolySpells = True
        elif spellsAllowed == "enchanted":
            self.allowMagicSpells = True
        elif spellsAllowed == "both":
            self.allowHolySpells = True
            self.allowMagicSpells = True
        pass

    def makeMaze(self):
        if self.mazeType == "haunted":
            return HauntedMaze()
        elif self.mazeType == "enchanted":
            return EnchantedMaze()
        else:
            return Maze()

    def makeRoom(self):
        if self.mazeType == "haunted":
            return HauntedRoom()
        elif self.mazeType == "enchanted":
            return EnchantedRoom()
        else:
            return Room()

    def makeWall(self):
        if self.mazeType == "haunted":
            return HauntedWall()
        elif self.mazeType == "enchanted":
            return EnchantedWall()
        else:
            return Wall()


hmg = HauntedMazeGame()
emg = EnchantedMazeGame()
hymg = CustomMazeGame(roomType="haunted", wallType="enchanted", spellsAllowed="both")

