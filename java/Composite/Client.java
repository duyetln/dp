package com.georgef.javacomposite;

/**
 * Created by georgef on 5/22/16.
 * Main application
 */
public class Client
{
    public static void main( String[] args )
    {
        Cabinet cabinet = new Cabinet( "PC Cabinet" );
        Chassis chassis = new Chassis( "PC Chassis" );

        cabinet.add( chassis );

        Bus bus = new Bus( "MCA Bus" );
        bus.add( new Card( "16Mbs Token Ring Card" ) );

        chassis.add( bus );
        chassis.add( new FloppyDisk( "3.5in Floppy" ) );

        System.out.println( "The net price is " + cabinet.netPrice() );
    }
}