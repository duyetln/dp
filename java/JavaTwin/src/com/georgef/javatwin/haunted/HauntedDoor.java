package com.georgef.javatwin.haunted;

import com.georgef.javatwin.Door;
import com.georgef.javatwin.Room;

/**
 * Created by georgef on 5/27/16.
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
