/**
 * Base equipment class
 */

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Equipment implements Iterable<Equipment>
{
    private String name;
    public double price;

    protected Equipment( String name )
    {
        this.name = name;
    }

    public void add( Equipment equipment ) throws OperationNotSupportedException
    {
        throw new OperationNotSupportedException();
    }

    public void remove( Equipment equipment ) throws OperationNotSupportedException
    {
        throw new OperationNotSupportedException();
    }

    @Override
    public Iterator<Equipment> iterator()
    {
        return new Iterator<Equipment>()
        {
            @Override
            public boolean hasNext()
            {
                return false;
            }

            @Override
            public Equipment next()
            {
                return null;
            }

            @Override
            public void remove()
            {
            }
        };
    }
}

class Bundle extends Equipment
{
    private List<Equipment> equipmentList;

    protected Bundle(String name )
    {
        super( name );
        equipmentList = new ArrayList<Equipment>();
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
    public Iterator<Equipment> iterator()
    {
        return equipmentList.iterator();
    }
}

class GraphicsCard extends Equipment
{
    public GraphicsCard(String name )
    {
        super( name );
        super.price = 45;
    }
}

class CPU extends Equipment
{
    public CPU(String name )
    {
        super( name );
        super.price = 75;
    }
}

class Motherboard extends Equipment
{
    public Motherboard(String name )
    {
        super( name );
        super.price = 150;
    }
}


