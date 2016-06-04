/**
 * Created by georgef on 5/25/16.
 */
public class Client
{
    public static void main( String[] args )
    {
        Button ok = new Button();
        Button cancel = new Button();

        ok.attach(new EntryField(ok));
        ok.attach(new ListBox(cancel));

        ok.click();
        cancel.click();
    }
}
