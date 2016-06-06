import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by georgef on 6/3/16.
 */
abstract class Pricing {

    abstract double calculate(ArrayList <Equipment> equipmentList);
}

class OneItemPricing extends Pricing {

    public double calculate(ArrayList <Equipment> equipmentList) {

        return equipmentList.get(0).price;
    }
}

class TwoItemsPricing extends Pricing {

    public double calculate(ArrayList <Equipment> equipmentList) {

        double max = 0;

        for (Equipment equipment : equipmentList) {
            if (equipment.price > max) {
                max = equipment.price;
            }
        }
        return max;
    }
}

class BundlePricing extends Pricing {

    public double calculate(ArrayList <Equipment> equipmentList) {

        double price = 0;

        for (Equipment equipment : equipmentList) {

            price += equipment.price;
        }
        return price;
    }
}
