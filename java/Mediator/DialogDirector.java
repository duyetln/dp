package com.georgef.javamediator;

/**
 * Created by georgef on 5/22/16.
 * The abstract class DialogDirector defines the interface for directors.
 */
public abstract class DialogDirector
{
    public abstract void showDialog();

    public abstract void widgetChanged( Widget widget );

    protected abstract void createWidgets();
}