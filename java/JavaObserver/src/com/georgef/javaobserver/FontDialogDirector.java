package com.georgef.javaobserver;

/**
 * Created by georgef on 5/25/16.
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
        this.ok.attach(this);
        this.cancel.attach(this);
        this.fontList.attach(this);
        this.fontName.attach(this);
    }

//    @Override
//    public void showDialog()
//    {
//        System.out.println( "FontDialogDirector: showing dialog..." );
//    }

    @Override
    public void update( Subject changedWidget )
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