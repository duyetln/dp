package com.georgef.javatwin.enchanted;

import com.georgef.javatwin.Door;
import com.georgef.javatwin.MazeGame;
import com.georgef.javatwin.Room;
import com.georgef.javatwin.Wall;
import com.georgef.javatwin.haunted.HauntedMazeGame;

/**
 * Created by georgef on 5/27/16.
 */
public class EnchantedMazeGame extends MazeGame implements MagicSpell
{
    private HauntedMazeGame twin;

    public void setTwin(HauntedMazeGame twin) {
        this.twin = twin;
    }

    @Override
    public Room makeRoom(int num )
    {
        return new EnchantedRoom( num );
    }

    @Override
    public Wall makeWall()
    {
        return new EnchantedWall();
    }

    @Override
    public Door makeDoor(Room r1, Room r2 )
    {
        return new EnchantedDoor( r1, r2 );
    }

    @Override
    public void setMagicSpell() {
        System.out.println("Setting a magic spell!");
    }

    public void setHolySpell() {
        twin.setHolySpell();
    }
}
