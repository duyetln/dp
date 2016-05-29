package com.georgef.javafactory.enchanted;

import com.georgef.javafactory.Room;

/**
 * Created by georgef on 5/22/16.
 */
public class EnchantedRoom extends Room
{
    public EnchantedRoom( int roomNo )
    {
        super( roomNo );
    }

    @Override
    public void enter()
    {
        System.out.print("EnchantedRoom: ");
        super.enter();
    }

}