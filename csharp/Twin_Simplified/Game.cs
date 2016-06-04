using System;
/* This is the simplified implementation for Twin.
    The playable game is in the folder marked Twin
*/

namespace DesignPatterns.Twin_Simplified
{
    abstract class MazeGame
    {
        public abstract Maze makeMaze();
        public abstract Room makeRoom();
        public abstract Wall makeWall();

        public Maze createMaze()
        {
            Maze maze = new Maze();

            maze.addRoom(new Room(""));
            maze.addRoom(new Room(""));
            maze.addWall(new Wall(""));
            maze.addWall(new Wall(""));

            return maze;
        }
    }

    class BasicMazeGame : MazeGame
    {
        public override Maze makeMaze()
        {
            return new Maze();
        }

        public override Room makeRoom()
        {
            return new Room("Basic Room");
        }

        public override Wall makeWall()
        {
            return new Wall("Basic Wall");
        }
    }

    class HauntedMazeGame : BasicMazeGame, HolySpell
    {
        public new Room makeRoom()
        {
            return new HauntedRoom("Haunted Room");
        }

        public void HolySpell()
        {
            Console.Write("Holy Spell Invoked...");

        }
    }

    class EnchantedMazeGame : BasicMazeGame,MagicSpell
    {
        public new Wall makeWall()
        {
            return new EnchantedWall("Enchanted wall");
        }

        public void MagicSpell()
        {
            Console.Write("Magic Spell Invoked");
        }
    }

    class HybridMazeGame : EnchantedMazeGame
    {
        private HauntedMazeGame twin = new HauntedMazeGame();

        public void setTwin(HauntedMazeGame twin)
        {
            this.twin = twin;
        }

        public new Room makeRoom()
        {
            return twin.makeRoom();
        }

        public void HolySpell()
        {
            twin.HolySpell();
        }
    }
}
