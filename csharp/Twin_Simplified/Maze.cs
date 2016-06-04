using System.Collections.Generic;
using System.Linq;

namespace DesignPatterns.Twin_Simplified
{
    class Maze
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
    }

}
