namespace DesignPatterns.Strategy
{
    class Purchase
    {
        Equipment el;
        Pricing pricing;
        double total;

        public Purchase(Equipment e)
        {
            el = e;
            pricing = new NormalPricing();
        }

        public double Total
        {
            get
            {
                return pricing.calculate(el.price);
            }
        }

        internal Pricing Pricing
        {
            get
            {
                return pricing;
            }

            set
            {
                pricing = value;
            }
        }
    }
}
