using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

    class Bundle : Equipment
    {
        private List<Equipment> elist;

        public Bundle(String name) : base(name)
        {
            elist = new List<Equipment>();
        }

        public void addEquipment(Equipment e)
        {
            elist.Add(e);
            base.price += e.price;
        }

        public void removeEquipment(Equipment e)
        {
            elist.Remove(e);
            base.price += e.price;
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
