using System;
using System.Collections.Generic;

/*
 Bare bones implementation for Maze 
*/

namespace DesignPatterns.Factory_Simplified
{
    abstract class Maze
    {
        List<Room> rooms = new List<Room>();
        List<Wall> walls = new List<Wall>();

        internal void addRoom(Room room)
        {
            rooms.Add(room);
        }

        internal void addWall(Wall wall)
        {
            walls.Add(wall);
        }

        abstract public void setUpRooms();
        abstract public void setUpWalls();
    }

    class BasicMaze : Maze
    {
        public override void setUpRooms()
        {
            addRoom(new Room("Basic Room"));
        }

        public override void setUpWalls()
        {
            addWall(new Wall("Basic Wall"));
        }
    }

    class HauntedMaze : BasicMaze, HolySpell
    {
        public void HolySpell()
        {
            Console.Out.WriteLine("Holy spell invoked!");
        }

        public override void setUpRooms()
        {
            addRoom(new HauntedRoom("Haunted Room"));
        }
    }

    class EnchantedMaze : BasicMaze, MagicSpell
    {
        public void MagicSpell()
        {
            Console.Out.WriteLine("Magic spell invoked!");
        }

        public override void setUpWalls()
        {
            addWall(new EnchantedWall("Enchanted Wall"));
        }
    }

    class HybridMaze : BasicMaze, MagicSpell, HolySpell
    {
        public void MagicSpell()
        {
            Console.Out.WriteLine("Magic spell invoked!");
        }

        public void HolySpell()
        {
            Console.Out.WriteLine("Holy spell invoked!");
        }

        public override void setUpRooms()
        {
            addRoom(new HauntedRoom("Haunted Room"));
        }

        public override void setUpWalls()
        {
            addWall(new EnchantedWall("Haunted Wall"));
        }
    }

}

















