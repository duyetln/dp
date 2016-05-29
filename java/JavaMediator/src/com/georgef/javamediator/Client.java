package com.georgef.javamediator;

/**
 * Created by georgef on 5/22/16.
 * Main application
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