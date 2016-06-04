using System.Collections.Generic;

namespace DesignPatterns.Strategy
{
    class Purchase
    {
        List<Equipment> el = new List<Equipment>();
        Pricing pricing;
        double total;

        public Purchase(Equipment e)
        {
            el.Add(e);
            pricing = new NormalPricing();
        }

        public void addPurchase(Equipment e)
        {
            el.Add(e);
            pricing = new NormalPricing();
        }

        public double Total
        {
            get
            {
                double sum = 0;
                foreach (Equipment x in el)
                {
                    if (x.GetType().Name.Equals("Bundle"))
                    {
                        pricing = new ComboPricing();
                    }
                    else
                    {
                        pricing = new ComboPricing();
                    }
                    sum = sum + pricing.calculate(x.price);                    
                }
              return sum;
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
