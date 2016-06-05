using System;
using System.Collections.Generic;

namespace DesignPatterns.Strategy
{
    abstract class Equipment
    {
        private string name;
        public double price;

        protected Equipment(string name)
        {
            this.name = name;
        }
    }

    class GraphicCard : Equipment
    {
        public GraphicCard(string name) : base(name)
        {
            base.price = 45;
        }
    }

    class CPU : Equipment
    {
        public CPU(string name) : base(name)
        {
            base.price = 75;
        }

    }

    class MotherBoard : Equipment
    {
        public MotherBoard(string name) : base(name)
        {
            base.price = 150;
        }
    }
}
