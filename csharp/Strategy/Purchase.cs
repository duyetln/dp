using System.Collections.Generic;

namespace DesignPatterns.Strategy
{
    class Purchase
    {
        List<Equipment> el = new List<Equipment>();
        Pricing pricing = new OneItemPricing();
        double total = 0;

        public void addPurchase(Equipment e)
        {
            el.Add(e);
        }

        public void removePurchase(Equipment e)
        {
            el.Remove(e);
        }

        public double Total
        {
            get
            {

                if (el.Count >2)
                {
                    pricing = new BundlePricing();
                }
                else if (el.Count > 1)
                {
                    pricing = new TwoItemPricing();
                }
                else
                {
                    pricing = new OneItemPricing();
                }
                total = total + pricing.calculate(el);  
                return total;
            }
        }
    }
}
