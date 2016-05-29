package com.georgef.javafactory;

import com.georgef.javafactory.enchanted.MagicSpell;
import com.georgef.javafactory.haunted.HolySpell;

/**
 * Created by georgef on 5/22/16.
 */
public class HybridMazeGame extends MazeGame implements MagicSpell, HolySpell {

    @Override
    public void setHolySpell()
    {
        System.out.println("Hybrid is setting a holy spell!...");
    }

    public void setMagicSpell()
    {
        System.out.println("Hybrid is setting a magic spell!...");
    }
}
