package com.georgef.javaobserverclock;

/**
 * Created by georgef on 5/25/16.
 */

public interface Observer
{
    public void update( Subject theChangedSubject );
}
