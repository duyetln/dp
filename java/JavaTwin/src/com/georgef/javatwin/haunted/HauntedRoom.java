package com.georgef.javatwin.haunted;

import com.georgef.javatwin.Room;

/**
 * Created by georgef on 5/27/16.
 */
public class HauntedRoom extends Room {

    public HauntedRoom(int roomNo)
    {
        super( roomNo );
    }

    @Override
    public void enter()
    {
        System.out.print("HauntedRoom: ");
        super.enter();
    }
}

