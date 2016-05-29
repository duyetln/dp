package com.georgef.javamediator;

/**
 * Created by georgef on 5/22/16.
 * Button is a simple widget that calls changed whenever it's pressed. This gets done
 * in its implementation of handleMouse
 */
public class Button extends Widget
{
    private String text;

    public Button( DialogDirector director )
    {
        super( director );
    }

    // Not really used
    public void setText( String text )
    {
        this.text = text;
    }

    // Not really used
    public String getText()
    {
        return text;
    }

    @Override
    public void handleMouse( MouseEvent event )
    {
        changed();
    }
}
