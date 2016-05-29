package com.georgef.javatwin.enchanted;

import com.georgef.javatwin.Wall;

/**
 * Created by georgef on 5/27/16.
 */
public class EnchantedWall extends Wall {

    public EnchantedWall()
    {
        super();
    }

    @Override
    public void enter()
    {
        System.out.println( "Enchanted Wall encountered!..." );
    }

}