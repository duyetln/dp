/**
 * Created by georgef on 5/29/16.
 */
public class MazeGame
{
    /*
     * Factory methods
     */
    public Maze makeMaze()
    {
        return new Maze();
    }

    public Room makeRoom(int roomNo )
    {
        return new Room( roomNo );
    }

    public Wall makeWall()
    {
        return new Wall();
    }

    /*
     * Creating maze
     */
    public Maze createMaze()
    {
        Maze maze = makeMaze();
        Room r1 = makeRoom( 1 );
        Room r2 = makeRoom( 2 );
        Wall w1 = makeWall();
        Wall w2 = makeWall();

        maze.addRoom( r1 );
        maze.addRoom( r2 );
        maze.addWall( w1 );
        maze.addWall( w2 );

        return maze;
    }
}

class HauntedMazeGame extends MazeGame implements HolySpell
{
    @Override
    public Room makeRoom(int num )
    {
        return new HauntedRoom( num );
    }

    @Override
    public void setHolySpell() {
        System.out.println("Setting a holy spell!");
    }

}

class EnchantedMazeGame extends MazeGame implements MagicSpell
{
    @Override
    public Wall makeWall()
    {
        return new EnchantedWall();
    }

    @Override
    public void setMagicSpell() {
        System.out.println("Setting a magic spell!");
    }
}

class HybridMazeGame extends MazeGame implements HolySpell
{
    @Override
    public Room makeRoom(int num )
    {
        return new HauntedRoom( num );
    }

    @Override
    public Wall makeWall()
    {
        return new EnchantedWall();
    }

    public void setHolySpell() {
        System.out.println("Hybrid:");
        System.out.println("Setting a holy spell!");
    }

    public void setMagicSpell() {
        System.out.println("Hybrid:");
        System.out.println("Setting a magic spell!");
    }
}