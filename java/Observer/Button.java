/**
 * Created by georgef on 5/25/16.
 */
public class Button extends Subject
{
    public void click()
    {
        System.out.println("click");
        notifyObservers();
    }
}
