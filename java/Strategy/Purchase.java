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

class Bundle extends Equipment
{
    private List< Equipment > equipmentList;

    protected Bundle(String name )
    {
        super( name );
        equipmentList = new ArrayList< Equipment >();
    }

    double price() {

        return price;
    }

    @Override
    public void add( Equipment equipment )
    {
        equipmentList.add( equipment );
        super.price += equipment.price;
    }

    @Override
    public void remove( Equipment equipment )
    {
        equipmentList.remove( equipment );
    }

    @Override
    public Iterator< Equipment > iterator()
    {
        return equipmentList.iterator();
    }
}