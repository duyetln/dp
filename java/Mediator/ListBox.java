package com.georgef.javamediator;

/**
 * Created by georgef on 5/22/16.
 * ListBox provides a getSelection operation to get the current selection
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
