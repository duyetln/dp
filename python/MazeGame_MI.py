class Room:
    def __init__(self, name="Room"):
        self.name = name


class Wall:
    def __init__(self, name="Wall"):
        self.name = name


class HauntedRoom(Room):
    def __init__(self):
        Room.__init__(self, "Haunted Room")


class EnchantedWall(Wall):
    def __init__(self):
        Wall.__init__(self, "Enchanted Wall")


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
        return m


class HauntedMazeGame(MazeGame):
    allowHolySpells = True

    def makeRoom(self):
        return HauntedRoom()


class EnchantedMazeGame(MazeGame):
    allowMagicSpells = True

    def makeWall(self):
        return EnchantedWall()


# MI hybridization solution:
class HybridMazeGame(HauntedMazeGame, EnchantedMazeGame):
    pass


########################################################

hmg = HauntedMazeGame()
emg = EnchantedMazeGame()
hymg = HybridMazeGame()
