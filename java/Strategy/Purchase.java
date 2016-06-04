import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by georgef on 6/3/16.
 */
public class Purchase {

    Equipment equipment;
    Pricing pricing;

    public Purchase(Equipment equipment) {
        this.equipment = equipment;
        this.pricing = new NormalPricing();
    }

    public double total() {
        return pricing.calculate(equipment.price);
    }
}