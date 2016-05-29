package com.georgef.javafactory;

import com.georgef.javafactory.enchanted.EnchantedMazeGame;
import com.georgef.javafactory.haunted.HauntedMazeGame;

/**
 * Created by georgef on 5/22/16.
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

		/*
		 * Using HauntedMazeGame
		 */
        HauntedMazeGame hauntedMazeGame = new HauntedMazeGame();
        maze = hauntedMazeGame.createMaze();
        maze.enterTheRoom( 2 );
        hauntedMazeGame.setHolySpell();

		/*
		 * Using EnchantedMazeGame
		 */
        EnchantedMazeGame magicMazeGame = new EnchantedMazeGame();
        maze = magicMazeGame.createMaze();
        maze.enterTheRoom( 3 );
        magicMazeGame.setMagicSpell();


        HybridMazeGame hybridMazeGame = new HybridMazeGame();
        maze = hybridMazeGame.createMaze();
        maze.enterTheRoom( 4 );
        hybridMazeGame.setHolySpell();
        hybridMazeGame.setMagicSpell();
    }
}