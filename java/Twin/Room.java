/**
 * Created by georgef on 5/29/16.
 */
public class Room
{
    private String name;

    public Room( String name )
    {
        this.name = name;
    }
}

class HauntedRoom extends Room {

    public HauntedRoom()
    {
        super( "Haunted Room" );
    }

}
