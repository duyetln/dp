package com.georgef.javamediator;

/**
 * Created by georgef on 5/22/16.
 * Widget is the abstract base class for widgets. A widget knows its director.
 */
public abstract class Widget
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
            director.widgetChanged( this );
        }
    }

    public void handleMouse( MouseEvent event )
    {
        System.out.println( "Widget: handling mouse event..." );
    }
}