/**
 * Created by georgef on 5/22/16.
 * EntryField's setText operation puts new text into the field
 */
public class EntryField extends Widget
{
    public EntryField( WidgetMediator director )
    {
        super( director );
    }

    public void setText()
    {
        System.out.println("setText");
    }

}