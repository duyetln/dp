import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgef on 6/3/16.
 */
public class Purchase {

    private ArrayList< Equipment > equipmentList;
    private double total = 0;
    Pricing pricing;

    public Purchase() {
        equipmentList = new ArrayList<Equipment>();
    }

    public void addEquipment(Equipment equipment) {
        if (!equipmentList.contains(equipment)) {
            equipmentList.add(equipment);
        }
    }

    public void removeEquipment(Equipment equipment) {
        if (equipmentList.contains(equipment)) {
            equipmentList.remove(equipment);
        }
    }

    public double price()
    {
        if (equipmentList.size() > 2) {
            pricing = new BundlePricing();
            total = pricing.calculate(equipmentList);
        }
        if (equipmentList.size() > 1) {
            pricing = new TwoItemsPricing();
            total = pricing.calculate(equipmentList);
        }
        if (equipmentList.size() > 0) {
            pricing = new OneItemPricing();
            total = pricing.calculate(equipmentList);
        }
        else {
            total = 0;
        }

        return total;
    }
}