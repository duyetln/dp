package com.georgef.javaobserverclock;

/**
 * Created by georgef on 5/25/16.
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Subject
{
    private List< Observer > observers;

    protected Subject()
    {
        observers = new ArrayList< Observer >();
    }

    public void attach( Observer observer )
    {
        observers.add( observer );
    }

    public void detach( Observer observer )
    {
        observers.remove( observer );
    }

    public void notifySubject()
    {
        for( Observer observer : observers )
        {
            observer.update( this );
        }
    }
}
