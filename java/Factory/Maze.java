/**
 * Created by georgef on 5/29/16.
 */
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> roomList = new ArrayList<>();
    private List<Wall> wallList = new ArrayList<>();

    public void addRoom(Room room) {
        roomList.add(room);
    }
    public void addWall(Wall wall) {
        wallList.add(wall);
    }
}