using System;

namespace DesignPatterns.Factory_Simplified
{
    class Wall
    {
        private String name;

        public Wall(string n)
        {
            this.name = n;
        }
    }   

    class EnchantedWall : Wall
    {
        public  EnchantedWall(string n) : base(n) { }
    }
}
