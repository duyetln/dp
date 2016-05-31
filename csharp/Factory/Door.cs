using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Factory
{
    public class Door:Pass
    {
        private int room1, room2;

        public Door(int r1, int r2)
        {
            Room1 = r1;
            Room2 = r2;
        }

        public int Room1
        {
            get
            {
                return room1;
            }

            set
            {
                room1 = value;
            }
        }

        public int Room2
        {
            get
            {
                return room2;
            }

            set
            {
                room2 = value;
            }
        }

        public void display()
        {
            Console.Write("Door" + Room1 + Room2);
        }

        public int pass(int currentLocation, Directions d)
        {
            Console.WriteLine("Door...");
            currentLocation = Room1 + Room2 - currentLocation;
            Console.WriteLine("New Room..." + currentLocation);
            return currentLocation;
        }

    }

    public class EnchantedDoor :Door
    {
        bool enchantment = true;
        int r = new Random().Next()%2;

        public EnchantedDoor(int r1, int r2) : base(r1, r2) { }
        
        public new int pass(int currentLocation, Directions d)
        {
            Console.WriteLine("Enchanted Door...");
            if(enchantment = true && r==0) 
            {
                currentLocation = Room1 + Room2 - currentLocation;
            }
            Console.WriteLine("New Room..." + currentLocation);
            return currentLocation;
        }

    }

    public class HauntedDoor : Door
    {
        bool haunting = true;
        int r = new Random().Next() % 2;

        public HauntedDoor(int r1, int r2) : base(r1, r2) { }

        public new int pass(int currentLocation, Directions d)
        {
            Console.WriteLine("Haunted Door...");
            if (haunting = true && r == 0)
            {
                currentLocation = Room1 + Room2 - currentLocation;
            }
            else
            {
                currentLocation = 0;
            }
            Console.WriteLine("New Room..." + currentLocation);
            return currentLocation;
        }

    }

}
