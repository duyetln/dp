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
