package com.georgef.javaobserver;

/**
 * Created by georgef on 5/25/16.
 */
public class Button extends Widget
{

    public Button( DialogDirector director )
    {
        super( director );
    }


    @Override
    public void handleMouse( MouseEvent event )
    {
        changed();
    }
}
