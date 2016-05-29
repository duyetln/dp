package com.georgef.javafactory.haunted;

import com.georgef.javafactory.Room;

/**
 * Created by georgef on 5/22/16.
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
