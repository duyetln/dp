/**
 * Main application
 */
public class Client
{
    public static void main( String[] args )
    {
        CPU cpu = new CPU("i7");
        GraphicsCard gcd = new GraphicsCard("GTX 900");
        Motherboard mbd = new Motherboard("EVGA Z710 FTW");
        Purchase pur = new Purchase();

        pur.addEquipment(cpu);
        System.out.println(pur.price());
        pur.addEquipment(gcd);
        System.out.println(pur.price());
        pur.addEquipment(mbd);
        System.out.println(pur.price());
    }
}