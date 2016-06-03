/**
 * Created by georgef on 5/29/16.
 */
public class Wall
{
    public void enter()
    {
        System.out.println( "Wall encountered!..." );
    }
}

class EnchantedWall extends Wall {

    public EnchantedWall()
    {
        super();
    }

    @Override
    public void enter()
    {
        System.out.println( "Enchanted Wall encountered!..." );
    }

}
