package com.georgef.javatwin;

/**
 * Created by georgef on 5/27/16.
 */
public class Wall implements MapSite
{
    @Override
    public void enter()
    {
        System.out.println( "Wall encountered!..." );
    }
}
