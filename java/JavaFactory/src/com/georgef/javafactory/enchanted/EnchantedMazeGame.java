package com.georgef.javafactory.enchanted;

import com.georgef.javafactory.Door;
import com.georgef.javafactory.MazeGame;
import com.georgef.javafactory.Room;
import com.georgef.javafactory.Wall;

/**
 * Created by georgef on 5/22/16.
 */
public class EnchantedMazeGame extends MazeGame implements MagicSpell
{
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
}