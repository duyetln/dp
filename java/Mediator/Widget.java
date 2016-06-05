/**
 * Created by georgef on 5/22/16.
 * Widget is the abstract base class for widgets. A widget knows its director.
 */
public abstract class Widget
{
    private WidgetMediator director;

    public Widget( WidgetMediator director )
    {
        this.director = director;
    }

    public void changed()
    {
        if( director != null )
        {
            director.widgetChanged( this );
        }
    }
}