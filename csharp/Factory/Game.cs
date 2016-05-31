using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Factory
{
    class MazeGame
    {
        public Room createRoom(int r)
        {
            return new Room(r);
        }

        public Door makeDoor(int d1,int d2)
        {
            return new Door(d1, d2);
        }

        public Wall makeWall()
        {
            return new Wall();
        }

        public Maze createMaze()
        {
            Maze maze = new Maze();
            Room r1 = createRoom(0);
            Room r2 = createRoom(1);
            Room r3 = createRoom(2);
            Room r4 = createRoom(3);

            maze.CurrentLocation = 0;

            Door door1 = makeDoor(0, 1);
            Door door2 = makeDoor(1, 2);
            Door door3 = makeDoor(2, 3);

            r1.setSide(Directions.North, door1);
            r1.setSide(Directions.East, makeWall());
            r1.setSide(Directions.South, makeWall());
            r1.setSide(Directions.West, makeWall());

            r2.setSide(Directions.North, makeWall());
            r2.setSide(Directions.East, door2);
            r2.setSide(Directions.South, door1);
            r2.setSide(Directions.West, makeWall());

            r3.setSide(Directions.North, makeWall());
            r3.setSide(Directions.East, makeWall());
            r3.setSide(Directions.South, door3);
            r3.setSide(Directions.West, door2);

            r4.setSide(Directions.North, door3);
            r4.setSide(Directions.East, makeWall());
            r4.setSide(Directions.South, makeWall());
            r4.setSide(Directions.West, makeWall());

            maze.addRoom(r1);
            maze.addRoom(r2);
            maze.addRoom(r3);
            maze.addRoom(r4);

            return maze;
        }

        internal void playGame(Maze maze)
        {
            bool play = true;
            int dir = 0;
            String x = null;
            while (play == true)
            {
                Console.WriteLine("Enter direction:");
                x = Console.ReadLine();
                dir = int.Parse(x);

                if (dir > 3)
                {
                    play = false;
                }
                else
                {
                    maze.move((Directions)dir);
                }

            }
            Console.WriteLine("Play ends:");
        }
    }

    class HauntedMazeGame : MazeGame, HolySpell
    {
        public new Room createRoom(int r)
        {
            return new HauntedRoom(r);
        }

        public new Door makeDoor(int d1, int d2)
        {
            return new HauntedDoor(d1, d2);
        }

        public new Wall makeWall()
        {
            return new HauntedWall();
        }

        public new Maze createMaze()
        {
            Maze maze = new Maze();
            Room r1 = createRoom(0);
            Room r2 = createRoom(1);
            Room r3 = createRoom(2);
            Room r4 = createRoom(3);

            maze.CurrentLocation = 0;

            Door door1 = makeDoor(0, 1);
            Door door2 = makeDoor(1, 2);
            Door door3 = makeDoor(2, 3);

            r1.setSide(Directions.North, door1);
            r1.setSide(Directions.East, makeWall());
            r1.setSide(Directions.South, makeWall());
            r1.setSide(Directions.West, makeWall());

            r2.setSide(Directions.North, makeWall());
            r2.setSide(Directions.East, door2);
            r2.setSide(Directions.South, door1);
            r2.setSide(Directions.West, makeWall());

            r3.setSide(Directions.North, makeWall());
            r3.setSide(Directions.East, makeWall());
            r3.setSide(Directions.South, door3);
            r3.setSide(Directions.West, door2);

            r4.setSide(Directions.North, door3);
            r4.setSide(Directions.East, makeWall());
            r4.setSide(Directions.South, makeWall());
            r4.setSide(Directions.West, makeWall());

            maze.addRoom(r1);
            maze.addRoom(r2);
            maze.addRoom(r3);
            maze.addRoom(r4);

            return maze;
        }

        public void HolySpell()
        {
            Console.Write("Holy Spell Invoked...");

        }

        internal new void playGame(Maze maze)
        {
            bool play = true;
            int dir = 0;
            String x = null;
            while (play == true)
            {
                Console.WriteLine("Enter direction:");
                x = Console.ReadLine();
                dir = int.Parse(x);

                if (dir > 3)
                {
                    play = false;
                }
                else
                {
                    maze.move((Directions)dir);
                }

            }
            Console.WriteLine("Play ends:");
        }
    }

    class EnchantedMazeGame : MazeGame,MagicSpell
    {
        public new Room createRoom(int r)
        {
            return new EnchantedRoom(r);
        }

        public new Door makeDoor(int d1, int d2)
        {
            return new EnchantedDoor(d1, d2);
        }

        public new Wall makeWall()
        {
            return new EnchantedWall();
        }

        public new Maze createMaze()
        {
            Maze maze = new Maze();
            Room r1 = createRoom(0);
            Room r2 = createRoom(1);
            Room r3 = createRoom(2);
            Room r4 = createRoom(3);

            maze.CurrentLocation = 0;

            Door door1 = makeDoor(0, 1);
            Door door2 = makeDoor(1, 2);
            Door door3 = makeDoor(2, 3);

            r1.setSide(Directions.North, door1);
            r1.setSide(Directions.East, makeWall());
            r1.setSide(Directions.South, makeWall());
            r1.setSide(Directions.West, makeWall());

            r2.setSide(Directions.North, makeWall());
            r2.setSide(Directions.East, door2);
            r2.setSide(Directions.South, door1);
            r2.setSide(Directions.West, makeWall());

            r3.setSide(Directions.North, makeWall());
            r3.setSide(Directions.East, makeWall());
            r3.setSide(Directions.South, door3);
            r3.setSide(Directions.West, door2);

            r4.setSide(Directions.North, door3);
            r4.setSide(Directions.East, makeWall());
            r4.setSide(Directions.South, makeWall());
            r4.setSide(Directions.West, makeWall());

            maze.addRoom(r1);
            maze.addRoom(r2);
            maze.addRoom(r3);
            maze.addRoom(r4);

            return maze;
        }

        public void MagicSpell()
        {
            Console.Write("Holy Spell Invoked");
        }
    }

    class HybridGame : MazeGame, HolySpell, MagicSpell
    {
        public void HolySpell()
        {
            Console.Write("Hybrid Holy Spell Invoked...");
        }

        public void MagicSpell()
        {
            Console.Write("Hybrid Magic Spell Invoked...");
        }
    }
}
