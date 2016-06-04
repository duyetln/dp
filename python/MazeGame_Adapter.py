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
    name = "Haunted Room"

class EnchantedWall(Wall):
    name = "Enchanted Wall"


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
        return Maze()
    def makeRoom(self):
        return Room()
    def makeWall(self):
        return Wall()
  

class HauntedMazeGame(MazeGame):
    allowHolySpells = True

    def makeRoom(self):
        return HauntedRoom()


class EnchantedMazeGame(MazeGame):

    allowMagicSpells = True

    def makeWall(self):
        return EnchantedWall()



# Adapter hybridization solution:
class AdaptedMazeGame:

    def __init__(self, emg, hmg):
        self.EMG = emg
        self.HMG = hmg
        self.allowMagicSpells = emg.allowMagicSpells
        self.allowHolySpells = hmg.allowHolySpells

    def makeWall(self):
        self.EMG.makeWall()
        
    def makeRoom(self):
        self.HMG.makeRoom()


hmg = HauntedMazeGame()
emg = EnchantedMazeGame()
amg = AdaptedMazeGame(emg, hmg)

print(amg.allowMagicSpells)
