using System.Collections.Generic;

namespace DesignPatterns.Strategy
{
    class Purchase
    {
        List<Equipment> el = new List<Equipment>();
        Pricing pricing;
        double total = 0;

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
                total = 0;
                foreach (Equipment x in el)
                {
                    if (x.GetType().Name.Equals("Bundle"))
                    {
                        pricing = new ComboPricing();
                    }
                    else
                    {
                        pricing = new NormalPricing();
                    }
                    total = total + pricing.calculate(x.price);                    
                }
              return total;
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
