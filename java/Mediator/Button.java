/**
 * Created by georgef on 5/22/16.
 * Button is a simple widget that calls changed whenever it's pressed. This gets done
 * in its implementation of handleMouse
 */
public class Button extends Widget
{
    public Button( WidgetMediator director )
    {
        super( director );
    }

    public void click()
    {
        System.out.println("click");
    }
}
