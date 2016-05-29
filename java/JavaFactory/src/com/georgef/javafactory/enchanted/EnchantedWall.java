package com.georgef.javafactory.enchanted;

import com.georgef.javafactory.Wall;

/**
 * Created by georgef on 5/22/16.
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
