package com.georgef.javatwin.haunted;

import com.georgef.javatwin.Door;
import com.georgef.javatwin.MazeGame;
import com.georgef.javatwin.Room;
import com.georgef.javatwin.Wall;
import com.georgef.javatwin.enchanted.EnchantedMazeGame;

/**
 * Created by georgef on 5/27/16.
 */
public class HauntedMazeGame extends MazeGame implements HolySpell
{
    private EnchantedMazeGame twin;

    public void setTwin(EnchantedMazeGame twin) {
        this.twin = twin;
    }

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

    public void setMagicSpell() {
        twin.setMagicSpell();

    }
}