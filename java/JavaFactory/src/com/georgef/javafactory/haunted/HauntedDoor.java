package com.georgef.javafactory.haunted;

import com.georgef.javafactory.Door;
import com.georgef.javafactory.Room;

/**
 * Created by georgef on 5/22/16.
 */
public class HauntedDoor extends Door {

    public HauntedDoor(Room r1, Room r2)
    {
        super(r1, r2);
    }

    public void enter()
    {
        System.out.println( "Haunted Door encountered!..." );
    }


}
