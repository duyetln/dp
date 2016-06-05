/**
 * Created by georgef on 5/22/16.
 * Main application
 */
public class Client
{
    public static void main( String[] args )
    {
        FrontDialogMediator director = new FrontDialogMediator();
        Button ok = director.ok;
        Button cancel = director.cancel;

        ok.click();
        cancel.click();
    }
}