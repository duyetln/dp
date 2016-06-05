import java.util.List;

/**
 * Created by georgef on 5/25/16.
 */
public class ListBox implements Observer
{
    Button button;

    public ListBox(Button button)
    {
        this.button = button;
    }

    public void setList()
    {
        System.out.println("setList");
    }

    public void update(Subject subject)
    {
        if (subject == button)
        {
            setList();
        }
    }
}