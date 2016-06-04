/**
 * Created by georgef on 5/25/16.
 */
public class EntryField implements Observer
{
    Button button;

    public EntryField(Button button)
    {
        this.button = button;
    }

    public void setText()
    {
        System.out.println("setText");
    }

    public void update(Subject subject)
    {
        if (subject == button)
        {
            setText();
        }
    }
}
