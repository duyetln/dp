package com.georgef.javafactory.haunted;

import com.georgef.javafactory.Door;
import com.georgef.javafactory.MazeGame;
import com.georgef.javafactory.Room;
import com.georgef.javafactory.Wall;

/**
 * Created by georgef on 5/22/16.
 */
public class HauntedMazeGame extends MazeGame implements HolySpell
{
    public Room makeRoom(int num )
    {
        return new HauntedRoom( num );
    }

    public Wall makeWall()
    {
        return new HauntedWall();
    }

    public Door makeDoor(Room r1, Room r2 )
    {
        return new HauntedDoor(r1, r2);
    }

    @Override
    public void setHolySpell() {
        System.out.println("Setting a holy spell!");
    }
}
