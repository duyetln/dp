/**
 * Created by georgef on 5/22/16.
 * The FrontDialogMediator class mediates between widgets in the dialog box.
 * It is a subclass of WidgetMediator.
 */
public class FrontDialogMediator extends WidgetMediator
{
    public Button ok = new Button( this );
    public Button cancel = new Button( this );
    public ListBox box = new ListBox( this );
    public EntryField entry = new EntryField( this );

    @Override
    public void widgetChanged( Widget changedWidget )
    {
        if( changedWidget == ok )
        {
            entry.setText();
        }
        else if( changedWidget == cancel )
        {
            box.setList();

        }
    }
}