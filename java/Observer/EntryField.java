package com.georgef.javaobserver;

/**
 * Created by georgef on 5/25/16.
 */
public class EntryField extends Widget
{
    private String text;

    public EntryField( DialogDirector director )
    {
        super( director );
    }

    public String getText()
    {
        return text;
    }

    public void setText( String text )
    {
        this.text = text;
    }

    @Override
    public void handleMouse( MouseEvent event )
    {
        super.handleMouse( event );
    }
}
