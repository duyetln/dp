/**
 * Created by georgef on 5/29/16.
 */
public class Client
{
    public static void main( String[] args )
    {

        MazeGame mazeGame = new MazeGame();
        HauntedMazeGame hauntedMazeGame = new HauntedMazeGame();
        EnchantedMazeGame magicMazeGame = new EnchantedMazeGame();
        HybridMazeGame hybridMazeGame = new HybridMazeGame();

        mazeGame.createMaze();

        hauntedMazeGame.createMaze();
        hauntedMazeGame.setHolySpell();

        magicMazeGame.createMaze();
        magicMazeGame.setMagicSpell();

        hybridMazeGame.createMaze();
        hybridMazeGame.setMagicSpell();
        hybridMazeGame.setHolySpell();

    }
}
