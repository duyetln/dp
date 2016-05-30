using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Composite
{
    abstract class Equipment
    {
        protected string name;
        private double power;
        private double price;
        public double getPower()
        {
            return power;
        }

        public double getPrice()
        {
            return price;
        }

        protected Equipment(string name)
        {
            this.name = name;
        }

        protected double Power
        {
            get
            {
                return power;
            }

            set
            {
                power = value;
            }
        }

        protected double Price
        {
            get
            {
                return price;
            }

            set
            {
                price = value;
            }
        }

        public abstract void Display();
    }

    class CompositeEquipment : Equipment
    {
        private List<Equipment> elist;

        protected CompositeEquipment(String name) :base(name)
        {
            elist = new List<Equipment>();
        }

        public void addComponent(Equipment e)
        {
            elist.Add(e);
            base.Power += e.getPower();
            base.Price += e.getPrice();
        }

        public void removeComponent(Equipment e)
        {
            elist.Remove(e);
            base.Power -= e.getPower();
            base.Price -= e.getPrice();
        }

        public override void Display()
        {
            Console.WriteLine("Composite Equipment:");
            // Display each child element on this node
            foreach (Equipment e in elist)
            {
                e.Display();
            }
        }
    }

    class GraphicCard : Equipment
    {
        public GraphicCard():base("Graphic Card")
        {
            base.Power = 120;
            base.Price = 50;
        }

        public override void Display()
        {
            Console.Out.WriteLine("\nEquipment:" + name + "\nPower:" + Power + "\nPrice:"+ Price);
        }
    }

    class CPU : Equipment
    {
        public CPU():base("CPU")
        {
            base.Power = 70;
            base.Price = 100;
        }

        public override void Display()
        {
            Console.Out.WriteLine("\nEquipment:" + name + "\nPower:" + Power + "\nPrice:" + Price);
        }

    }

    class MotherBoard :CompositeEquipment
    {
        public MotherBoard():base("Motherboard")
        {
            base.Price = 50;
            base.Power = 50;
        }
    }
}
