/**
 * Created by georgef on 5/29/16.
 */
public class Room
{
    private int roomNumber;

    public Room( int roomNo )
    {
        roomNumber = roomNo;
    }

    public void enter()
    {
        System.out.println( "Entering room " + roomNumber );
    }
}

class HauntedRoom extends Room {

    public HauntedRoom(int roomNo)
    {
        super( roomNo );
    }

    @Override
    public void enter() {
        System.out.print("HauntedRoom: ");
        super.enter();
    }
}
