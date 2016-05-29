class Room:
    def __init__(self):
        pass


class Wall:
    def __init__(self):
        pass


class Maze:

    rooms = []
    walls = []

    def __init__(self):
        pass

    def addRoom(self, r):
        if r not in self.rooms:
            self.rooms.append(r)

    def addWall(self, w):
        if w not in self.walls:
            self.walls.append(w)


class HauntedRoom(Room): pass
class HauntedWall(Wall): pass
class HauntedMaze(Maze): pass

class EnchantedRoom(Room): pass
class EnchantedWall(Wall): pass
class EnchantedMaze(Maze): pass


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
        # etc


class HauntedMazeGame(MazeGame):

    allowHolySpells = True

    def makeRoom(self):
        return HauntedRoom()


class EnchantedMazeGame(MazeGame):

    allowMagicSpells = True

    def makeWall(self):
        return EnchantedWall()


# Adapter hybridization solution:
class AdaptedMazeGame(HauntedMazeGame):

    def __init__(self, emg):
        self.EMG = emg
        self.allowMagicSpells = emg.allowMagicSpells

    def makeWall(self):
        self.EMG.makeWall()


hmg = HauntedMazeGame()
emg = EnchantedMazeGame()
amg = AdaptedMazeGame(emg)

print(amg.allowMagicSpells)
