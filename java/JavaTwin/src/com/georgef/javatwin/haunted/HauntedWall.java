package com.georgef.javatwin.haunted;

import com.georgef.javatwin.Wall;

/**
 * Created by georgef on 5/27/16.
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