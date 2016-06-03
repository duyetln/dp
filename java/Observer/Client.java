package com.georgef.javaobserver;

/**
 * Created by georgef on 5/25/16.
 */
public class Client
{
    public static void main( String[] args )
    {
        FontDialogDirector dialogDirector = new FontDialogDirector();
        dialogDirector.createWidgets();

        FontDialogDirector.pressOk( dialogDirector );
        FontDialogDirector.pressCancel( dialogDirector );
        FontDialogDirector.pressFontList( dialogDirector );
    }
}
