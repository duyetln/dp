using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Strategy
{
    abstract class Pricing
    {
        abstract public double calculate(double price);
    }

    class NormalPricing : Pricing
    {
        public override double calculate(double price)
        {
            return price;
        }
    }

    class ComboPricing : Pricing
    {
        public override double calculate(double price)
        {
            return (price * 0.8);
        }
    }
}
