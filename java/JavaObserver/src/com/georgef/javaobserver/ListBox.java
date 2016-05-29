package com.georgef.javaobserver;

/**
 * Created by georgef on 5/25/16.
 */
public class ListBox extends Widget
{
    public ListBox( DialogDirector director )
    {
        super( director );
    }

    @Override
    public void handleMouse( MouseEvent event )
    {
        super.handleMouse( event );
    }

    public String getSelection()
    {
        return null;
    }
}
