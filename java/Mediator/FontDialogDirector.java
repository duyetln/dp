package com.georgef.javamediator;

/**
 * Created by georgef on 5/22/16.
 * The FontDialogDirector class mediates between widgets in the dialog box.
 * It is a subclass of DialogDirector.
 */
public class FontDialogDirector extends DialogDirector
{
    private Button ok;
    private Button cancel;
    private ListBox fontList;
    private EntryField fontName;

    @Override
    protected void createWidgets()
    {
        this.ok = new Button( this );
        this.cancel = new Button( this );
        this.fontList = new ListBox( this );
        this.fontName = new EntryField( this );
    }

    @Override
    public void showDialog()
    {
        System.out.println( "FontDialogDirector: showing dialog..." );
    }

    @Override
    public void widgetChanged( Widget changedWidget )
    {
        if( changedWidget == fontList )
        {
            System.out.println( "Setting fontName.text = fontList.getSelection()..." );
            fontName.setText( fontList.getSelection() );
        }
        else if( changedWidget == ok )
        {
            System.out.println( "Modifying font..." );

        }
        else if( changedWidget == cancel )
        {
            System.out.println( "Closing the dialog..." );
        }
    }

    public static void pressOk( FontDialogDirector director )
    {
        director.ok.handleMouse( new MouseEvent() );
    }

    public static void pressCancel( FontDialogDirector director )
    {
        director.cancel.handleMouse( new MouseEvent() );
    }

    public static void pressFontList( FontDialogDirector director )
    {
        director.fontList.handleMouse( new MouseEvent() );
    }
}