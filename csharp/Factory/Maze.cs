using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Factory
{
    interface Pass
    {
        int pass(int currentLocation, Directions d);
        void display();
    }
    public enum Directions
    {
        North = 0, East = 1, South = 2, West = 3
    };
   
    class Maze
    {
        int currentLocation;
        List<Room> rooms = new List<Room>();

        public void move(Directions d)
        {
            Room cur = rooms.ElementAt(currentLocation);
            currentLocation = cur.pass(currentLocation, d);
        }

        internal int CurrentLocation
        {
            get
            {
                return currentLocation;
            }

            set
            {
                currentLocation = value;
            }
        }

        internal void addRoom(Room room)
        {
            rooms.Add(room);
        }
    }

}
