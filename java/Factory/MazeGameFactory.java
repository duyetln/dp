/**
 * Created by georgef on 5/29/16.
 */
public class MazeGameFactory
{
    public Maze createMaze(String type)
    {
        Maze maze;
        if (type.equals("Haunted")) {
            maze = new HauntedMazeGame();
        }
        else if (type.equals("Enchanted")) {
            maze = new EnchantedMazeGame();
        }
        else if (type.equals("Hybrid")) {
            maze = new HybridMazeGame();
        }
        else {
            maze = new BasicMazeGame();
        }

        maze.setupRooms();
        maze.setupWalls();

        return maze;
    }
}