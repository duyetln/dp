using System;

/*
 Bare bones implementation for Maze Game Factory
*/
namespace DesignPatterns.Factory_Simplified
{
    class MazeGameFactory
    {
        public Maze createMaze(String type)
        {
            Maze maze;
            if (type.Equals("haunted"))
                maze = new HauntedMaze();
            else if (type.Equals("enchanted"))
                maze = new EnchantedMaze();
            else if (type.Equals("hybrid"))
                maze = new HybridMaze();
            else
                maze = new BasicMaze();

            maze.setUpRooms();
            maze.setUpWalls();

            return maze;
        }
    }
}
