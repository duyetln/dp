package com.georgef.javatwin;

/**
 * Created by georgef on 5/27/16.
 */
public class Room implements MapSite
{
    private MapSite[] sides;
    private int roomNumber;

    public Room( int roomNo )
    {
        this.setRoomNumber( roomNo );
        this.sides = new MapSite[4];
    }

    public void setSide( Direction direction, MapSite site )
    {
        sides[direction.ordinal( )] = site;
    }

    @Override
    public void enter()
    {
        System.out.println( "Entering room " + getRoomNumber( ) );
        for( MapSite side : sides )
        {
            side.enter( );
        }
    }

    public int getRoomNumber()
    {
        return roomNumber;
    }

    private void setRoomNumber( int roomNumber )
    {
        this.roomNumber = roomNumber;
    }
}
