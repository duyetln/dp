/**
 * Created by georgef on 5/29/16.
 */
public class Wall
{
    private String name;

    public Wall(String name) {

        this.name = name;
    }
}

class EnchantedWall extends Wall {

    public EnchantedWall(String name)
    {
        super( name );
    }



}
