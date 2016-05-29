package com.georgef.javatwin;

import com.georgef.javatwin.enchanted.EnchantedMazeGame;
import com.georgef.javatwin.haunted.HauntedMazeGame;

/**
 * Created by georgef on 5/27/16.
 */
public class Client
{
    public static void main( String[] args )
    {
        MazeGame mazeGame = new MazeGame();

		/*
		 * Using standard MazeGame
		 */
        Maze maze = mazeGame.createMaze();
        maze.enterTheRoom( 1 );

        HauntedMazeGame hauntedMazeGame = new HauntedMazeGame();
        EnchantedMazeGame magicMazeGame = new EnchantedMazeGame();

        hauntedMazeGame.setTwin(magicMazeGame);
        magicMazeGame.setTwin(hauntedMazeGame);

		/*
		 * Using HauntedMazeGame
		 */
        maze = hauntedMazeGame.createMaze();
        maze.enterTheRoom( 2 );
        hauntedMazeGame.setHolySpell();
        hauntedMazeGame.setMagicSpell();

		/*
		 * Using EnchantedMazeGame
		 */
        maze = magicMazeGame.createMaze();
        maze.enterTheRoom( 3 );
        magicMazeGame.setMagicSpell();
        magicMazeGame.setHolySpell();
    }
}
