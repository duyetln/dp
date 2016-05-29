package com.georgef.javatwin.enchanted;

import com.georgef.javatwin.Room;

/**
 * Created by georgef on 5/27/16.
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
