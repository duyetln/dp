package com.georgef.javafactory;

/**
 * Created by georgef on 5/22/16.
 */
public class Wall implements MapSite
{
    @Override
    public void enter()
    {
        System.out.println( "Wall encountered!..." );
    }
}
