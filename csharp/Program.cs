using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DesignPatterns.Factory;
using DesignPatterns.Twin;
using DesignPatterns.Composite;

namespace DesignPatterns
{
    class Program
    {
        static void Main(string[] args)
        {
            int option = 2;

            switch(option)
            {
                case 0:
                    callTwin();
                    break;
                case 1:
                    callObserver();
                    break;
                case 2:
                    callFactory();
                    break;
                case 3:
                    callStrategy();
                    break;
                case 4:
                    callComposite();
                    break;
                case 5:
                    callMediator();
                    break;
                default:
                    Console.WriteLine("End");
                    break;
            }
        }

        private static void callStrategy()
        {
            Strategy.CPU cp = new Strategy.CPU("i7");
            Strategy.GraphicCard gc = new Strategy.GraphicCard("GTX 900");
            Strategy.MotherBoard mb = new Strategy.MotherBoard("EVGA Z710 FTW");
            Strategy.Bundle b = new Strategy.Bundle("Bundle ");

            b.addEquipment(cp);
            b.addEquipment(gc);
            b.addEquipment(mb);
            Strategy.Purchase p = new Strategy.Purchase(b);

            p.Pricing = new Strategy.NormalPricing();
            Console.Write("\nNormal Pricing:" + p.Total);

            p.Pricing = new Strategy.ComboPricing();
            Console.Write("\nCombo Pricing:" + p.Total);

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callComposite()
        {
            MotherBoard b = new MotherBoard();
            CPU cp = new CPU();
            GraphicCard gc = new GraphicCard();

            b.addComponent(cp);
            b.addComponent(gc);
            b.Display();

            Console.WriteLine("\nTotalPrice of Motherboard:" + b.getPrice());
            Console.WriteLine("\nTotalPower of Motherboard:" + b.getPower());

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callTwin()
        {
            Twin.HauntedMazeGame hauntedgame = new Twin.HauntedMazeGame();
            Twin.EnchantedMazeGame enchantedgame = new Twin.EnchantedMazeGame();


            Twin.HybridMazeGame hybridgame = new Twin.HybridMazeGame();
            hybridgame.setTwin(hauntedgame);
            Twin.Maze m = hybridgame.createMaze();
            hybridgame.playGame(m);
            hybridgame.HolySpell();
            hybridgame.MagicSpell();





            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callFactory()
        {
            Factory_Simplified.MazeGameFactory mazegame= new Factory_Simplified.MazeGameFactory();
            mazegame.createMaze("enchanted");

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callObserver()
        {
            Observer.FontDialogDirector d = new Observer.FontDialogDirector();
            d.createWidget();

            d.openFontList();
            d.pressOk();
            d.pressCancel();
            

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callMediator()
        {
            Mediator.FontDialogDirector d = new Mediator.FontDialogDirector();
            d.createWidget();
            d.openFontList();
            d.pressOk();
            d.pressCancel();


            Console.Write("End");
            Console.ReadLine();

        }

        private static void waiting()
        {
           //no-op
        }
    }
}
