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
            int option = 5;

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
                    callAdapter();
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

        

        private static void callComposite()
        {
            MotherBoard b = new MotherBoard();
            CPU cp = new CPU();
            GraphicCard gc = new GraphicCard();

            b.addComponent(cp);
            b.addComponent(gc);
            b.Display();

            Console.WriteLine("TotalPrice of Motherboard:" + b.getPrice());
            Console.WriteLine("TotalPower of Motherboard:" + b.getPower());

            Console.Write("End");
            Console.ReadLine();
        }

        private static void callAdapter()
        {
            Adapter.GameAdapter game= new Adapter.GameAdapter();
            Adapter.Maze m = game.createMaze();
            game.playGame(m);
            game.specialSpells();

            Console.Write("End");
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





            Console.Write("End");
            Console.ReadLine();
        }

        private static void callFactory()
        {
            Factory.MazeGame game = new Factory.MazeGame();
            Factory.Maze m = game.createMaze();
            game.playGame(m);

            Factory.EnchantedMazeGame enchantedgame = new Factory.EnchantedMazeGame();
            m = enchantedgame.createMaze();
            enchantedgame.playGame(m);
            enchantedgame.MagicSpell();


            Factory.HauntedMazeGame hauntedgame = new Factory.HauntedMazeGame();
            m = hauntedgame.createMaze();
            hauntedgame.playGame(m);
            hauntedgame.HolySpell();

            Factory.HybridGame hybridgame = new Factory.HybridGame();
            m = hybridgame.createMaze();
            hybridgame.playGame(m);
            hybridgame.HolySpell();
            hybridgame.MagicSpell();


        }

        private static void callObserver()
        {
            Observer.FontDialogDirector d = new Observer.FontDialogDirector();
            d.createWidget();

            d.openFontList();
            d.pressOk();
            d.pressCancel();
            

            Console.Write("End");
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
