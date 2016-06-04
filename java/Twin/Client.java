/**
 * Created by georgef on 5/29/16.
 */
public class Client
{
    public static void main( String[] args )
    {
        MazeGameFactory mazeGameFactory = new MazeGameFactory();

        HauntedMazeGame hauntedMazeGame = (HauntedMazeGame)mazeGameFactory.createMaze("Haunted");
        HybridMazeGame hybridMazeGame = (HybridMazeGame) mazeGameFactory.createMaze("Hybrid");
        hybridMazeGame.setTwin(hauntedMazeGame);
    }
}
