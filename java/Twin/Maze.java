/**
 * Created by georgef on 5/29/16.
 */
import java.util.ArrayList;
import java.util.List;

abstract class Maze {
    private List<Room> roomList = new ArrayList<>();
    private List<Wall> wallList = new ArrayList<>();

    public void addRoom(Room room) {
        roomList.add(room);
    }
    public void addWall(Wall wall) {
        wallList.add(wall);
    }

    abstract void setupRooms();
    abstract void setupWalls();
}

class BasicMazeGame extends Maze
{
    public void setupRooms()
    {
        addRoom(new Room("Basic Room"));
    }

    public void setupWalls()
    {
        addWall(new Wall("Basic Wall"));
    }
}

class HauntedMazeGame extends BasicMazeGame implements HolySpell
{
    public void setupRooms()
    {
        addRoom(new HauntedRoom());
    }

    @Override
    public void setHolySpell() {
        System.out.println("Setting a holy spell!");
    }
}

class EnchantedMazeGame extends BasicMazeGame implements MagicSpell
{
    public void setupWalls()
    {
        addWall(new EnchantedWall());
    }

    @Override
    public void setMagicSpell() {
        System.out.println("Setting a magic spell!");
    }
}

class HybridMazeGame extends EnchantedMazeGame implements MagicSpell
{
    private HauntedMazeGame twin = new HauntedMazeGame();

    public void setTwin(HauntedMazeGame twin)
    {
        this.twin = twin;
    }

    public void setupRooms()
    {
        twin.setupRooms();
    }

    public void setHolySpell() {
        twin.setHolySpell();
    }
}