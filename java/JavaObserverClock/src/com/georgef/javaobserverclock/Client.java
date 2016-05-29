package com.georgef.javaobserverclock;

/**
 * Created by georgef on 5/25/16.
 */
public class Client
{
    @SuppressWarnings( "unused" )
    public static void main( String[] args )
    {
        ClockTimer timer = new ClockTimer();
        AnalogClock analogClock = new AnalogClock( timer );
        DigitalClock digitalClock = new DigitalClock( timer );
        simulateClockTicks( timer );
    }

    private static void simulateClockTicks( ClockTimer timer )
    {
        for( int i = 0; i < 5; i++ )
        {
            timer.tick();
            try
            {
                Thread.sleep( 1000 );
            } catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }
}
