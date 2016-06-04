/**
 * Created by georgef on 6/3/16.
 */
abstract class Pricing {

    abstract double calculate(double price);
}

class ComboPricing extends Pricing {

    public double calculate(double price) {

        return (price * 0.8);
    }
}

class NormalPricing extends Pricing {

    public double calculate(double price) {

        return price;
    }
}
