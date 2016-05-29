package com.georgef.javafactory.enchanted;

import com.georgef.javafactory.Door;
import com.georgef.javafactory.Room;

/**
 * Created by georgef on 5/22/16.
 */
public class EnchantedDoor extends Door {

    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    public void enter()
    {
        System.out.println( "Enchanted Door encountered!..." );
    }

}
