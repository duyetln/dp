using System;
using System.Collections.Generic;
using System.Linq;

namespace DesignPatterns.Composite
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

    class Bundle : Equipment
    {
        private List<Equipment> elist;

        public new double price
        {
            get
            {
                return elist.Sum(r => r.price); ;
            }
        }

        public Bundle(String name) : base(name)
        {
            elist = new List<Equipment>();
        }

        public void addEquipment(Equipment e)
        {
            elist.Add(e);
        }

        public void removeEquipment(Equipment e)
        {
            elist.Remove(e);
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
