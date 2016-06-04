using System;

namespace DesignPatterns.Factory_Simplified
{
    class Room
    {
        private String name;

        public Room(string n)
        {
            this.name = n;
        }
    }

    class HauntedRoom : Room
    {
        public HauntedRoom(String x) : base(x) {}
    }
}
