package com.georgef.javacomposite;

/**
 * Created by georgef on 5/22/16.
 * Another subclass of CompositeEquipment
 */
public class Bus extends CompositeEquipment
{
    private static final int BUS_POWER = 100;
    private static final float BUS_NETPRICE = 95;
    private static final float BUS_DISCOUNTPRICE = 89.99f;

    protected Bus( String name )
    {
        super( name );
    }

    @Override
    public int power()
    {
        return super.power() + BUS_POWER;
    }

    @Override
    public float netPrice()
    {
        System.out.println( "Adding net price of Bus: " + BUS_NETPRICE );
        return super.netPrice() + BUS_NETPRICE;
    }

    @Override
    public float discountPrice()
    {
        return super.discountPrice() + BUS_DISCOUNTPRICE;
    }
}
