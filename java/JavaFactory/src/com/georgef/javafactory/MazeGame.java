package com.georgef.javafactory;

/**
 * Created by georgef on 5/22/16.
 */
public class MazeGame
{
    /*
     * Factory methods
     */
    public Maze makeMaze()
    {
        return new Maze();
    }

    public Room makeRoom( int roomNo )
    {
        return new Room( roomNo );
    }

    public Wall makeWall()
    {
        return new Wall();
    }

    public Door makeDoor( Room room1, Room room2 )
    {
        return new Door( room1, room2 );
    }

    /*
     * Creating maze
     */
    public Maze createMaze()
    {
        Maze maze = makeMaze();
        Room r1 = makeRoom( 1 );
        Room r2 = makeRoom( 2 );
        Room r3 = makeRoom( 3 );
        Room r4 = makeRoom( 4 );

        Door door = makeDoor( r1, r2 );
        Door door2 = makeDoor( r2, r3);
        Door door3 = makeDoor( r3, r4);

        maze.addRoom( r1 );
        maze.addRoom( r2 );
        maze.addRoom( r3 );
        maze.addRoom( r4 );

        r1.setSide( Direction.NORTH, makeWall( ) );
        r1.setSide( Direction.EAST, door );
        r1.setSide( Direction.SOUTH, makeWall( ) );
        r1.setSide( Direction.WEST, makeWall( ) );

        r2.setSide( Direction.NORTH, makeWall( ) );
        r2.setSide( Direction.EAST, makeWall( ) );
        r2.setSide( Direction.SOUTH, makeWall( ) );
        r2.setSide( Direction.WEST, door2 );

        r3.setSide( Direction.NORTH, door3 );
        r3.setSide( Direction.EAST, makeWall( ) );
        r3.setSide( Direction.SOUTH, makeWall( ) );
        r3.setSide( Direction.WEST, makeWall() );

        r4.setSide( Direction.NORTH, makeWall( ) );
        r4.setSide( Direction.EAST, makeWall( ) );
        r4.setSide( Direction.SOUTH, door );
        r4.setSide( Direction.WEST, makeWall( ) );

        return maze;
    }
}