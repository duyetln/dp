using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Adapter
{
    class Wall : Pass
    {
        public int pass(int currentLocation, Directions d)
        {
            display();
            Console.WriteLine("...cannot pass");
            return currentLocation;
        }
        public void display()
        {
            Console.Write("Wall");
        }
    }

    class HauntedWall: Wall
    {
        public new void display()
        {
            Console.Write("Haunted Wall");
        }
    }

    class EnchantedWall : Wall
    {
        public new void display()
        {
            Console.Write("Enchanted Wall");
        }
    }
}
