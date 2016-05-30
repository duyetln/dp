using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Factory
{
    class Room : Pass
    {
        private int roomNumber;
        private Pass[] sides;

        public Room(int x)
        {
            RoomNumber = x;
            sides = new Pass[4];
        }

        //Getters and Setters

        public void setSide(Directions d, Pass p)
        {
            sides[(int)d] = p;
        }

        public Pass getSide(Directions d)
        {
            return sides[(int)d];
        }

        public int RoomNumber
        {
            get
            {
                return roomNumber;
            }

            set
            {
                roomNumber = value;
            }
        }

        //Implement interface
        public int pass(int currentLocation, Directions d)
        {
            display();
            currentLocation = sides[(int)d].pass(currentLocation, d);

            return currentLocation;
        }

        internal bool equals(Room room1)
        {
            if (this.RoomNumber == room1.RoomNumber)
                return true;
            else
                return false;
        }

        public void display()
        {
            Console.WriteLine("Room:" + this.RoomNumber);
            Console.WriteLine("NESW:");
            sides[0].display();
            sides[1].display();
            sides[2].display();
            sides[3].display();
        }
    }

    class HauntedRoom : Room
    {
        public HauntedRoom(int x) : base(x) {}
        public new void display()
        {
            Console.Write("Haunted");
            base.display();
        }
    }

    class EnchantedRoom : Room
    {
        public EnchantedRoom(int x) : base(x) {}

        public new void display()
        {
            Console.Write("Enchanted");
            base.display();
        }
    }

}
