package com.georgef.javaobserverclock;

/**
 * Created by georgef on 5/25/16.
 */
public class DigitalClock extends Widget implements Observer
{
    private ClockTimer subject;

    public DigitalClock( ClockTimer subject )
    {
        this.subject = subject;
        this.subject.attach( this );
    }

    @Override
    public void update( Subject theChangedSubject )
    {
        if( theChangedSubject == subject )
        {
            draw();
        }
    }

    @Override
    public void draw()
    {
        int hour = subject.getHour();
        int min = subject.getMinute();
        int sec = subject.getSecond();
        System.out.println( "DigitalClock.draw(): (" + hour + ":" + min + ":" + sec + ")" );
    }

    @Override
    protected void finalize() throws Throwable
    {
        try
        {
            if( subject != null )
            {
                System.out.println( "DigitalClock.finalize(): detach" );
                subject.detach( this );
            }
        } catch( Throwable t )
        {
            throw t;
        } finally
        {
            super.finalize();
        }
    }
}
