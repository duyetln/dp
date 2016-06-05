using System.Collections.Generic;
using System.Linq;

namespace DesignPatterns.Strategy
{
    abstract class Pricing
    {
        abstract public double calculate(List<Equipment> e);
    }

    class OneItemPricing : Pricing
    {
        public override double calculate(List<Equipment> e)
        {
            return e.Sum(r => r.price);
        }
    }

    class TwoItemPricing : Pricing
    {
        public override double calculate(List<Equipment> e)
        {
            return e.Max(r => r.price);
        }
    }

    class BundlePricing : Pricing
    {
        public override double calculate(List<Equipment> e)
        {
            return e.Sum(r => r.price)*0.7;
        }
    }
}
