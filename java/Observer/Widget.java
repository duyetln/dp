package com.georgef.javaobserver;

/**
 * Created by georgef on 5/25/16.
 */
public abstract class Widget extends Subject
{
    private DialogDirector director;

    public Widget( DialogDirector director )
    {
        this.director = director;
    }

    public void changed()
    {
        if( director != null )
        {
            notifySubject();
        }
    }

    public void handleMouse( MouseEvent event )
    {
        System.out.println( "Widget: handling mouse event..." );
    }
}
