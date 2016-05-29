package com.georgef.javafactory.haunted;

import com.georgef.javafactory.Wall;

/**
 * Created by georgef on 5/22/16.
 */
public class HauntedWall extends Wall {

    public HauntedWall()
    {
        super();
    }

    @Override
    public void enter()
    {
        System.out.println( "Haunted Wall encountered!..." );
    }

}
