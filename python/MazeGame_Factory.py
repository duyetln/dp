class Room:
    def __init__(self, name="Room"):
        self.name = name


class Wall:
    def __init__(self, name="Wall"):
        self.name = name


class Maze:

    def __init__(self, name="Maze"):
        self.name = name
        self.rooms = []
        self.walls = []

    def addRoom(self, r):
        if r not in self.rooms:
            self.rooms.append(r)

    def addWall(self, w):
        if w not in self.walls:
            self.walls.append(w)


class HauntedRoom(Room):
    def __init__(self):
        Room.__init__(self, "Haunted Room")


class EnchantedWall(Wall):
    def __init__(self):
        Wall.__init__(self, "Enchanted Wall")


class BasicMaze(Maze):
    def setupRooms(self):
        self.addRoom(Room("Basic Room"))

    def setupWalls(self):
        self.addWall(Wall("Basic Wall"))


class HauntedMaze(BasicMaze):
    allowHolySpells = True

    def setupRooms(self):
        self.addRoom(HauntedRoom())
        self.addRoom(HauntedRoom())


class EnchantedMaze(BasicMaze):
    allowMagicSpells = True

    def setupWalls(self):
        self.addWall(EnchantedWall())
        self.addWall(EnchantedWall())
        self.addWall(EnchantedWall())


class HybridMaze(BasicMaze):
    allowHolySpells = True
    allowMagicSpells = True

    def setupRooms(self):
        self.addRoom(HauntedRoom())
        self.addRoom(HauntedRoom())

    def setupWalls(self):
        self.addWall(EnchantedWall())
        self.addWall(EnchantedWall())
        self.addWall(EnchantedWall())


def createMaze(t="Basic"):

    if t == "Haunted":
        m = HauntedMaze()
    elif t == "Enchanted":
        m = EnchantedMaze()
    elif t == "Hybrid":
        m = HybridMaze()
    else:
        m = BasicMaze()
    m.setupRooms()
    m.setupWalls()
    return m


hybrid_maze = createMaze("Hybrid")
