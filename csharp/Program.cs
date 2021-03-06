﻿using System;

namespace DesignPatterns
{
    class Program
    {
        static void Main(string[] args)
        {
            int option = 4;

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
                case 6:
                    callSimplifiedTwin();
                    break;
                default:
                    Console.WriteLine("End");
                    break;
            }
        }

        private static void callSimplifiedTwin()
        {
            Twin_Simplified.HybridMazeGame mazegame = new Twin_Simplified.HybridMazeGame();
            mazegame.createMaze();
            mazegame.HolySpell();
            mazegame.MagicSpell();

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callStrategy()
        {
            Strategy.CPU cp = new Strategy.CPU("i7");
            Strategy.GraphicCard gc = new Strategy.GraphicCard("GTX 900");
            Strategy.MotherBoard mb = new Strategy.MotherBoard("EVGA Z710 FTW");
            Strategy.Purchase p = new Strategy.Purchase();
            p.addPurchase(cp);
            p.addPurchase(gc);
            p.addPurchase(mb);

            Console.Write("\nPricing:" + p.Total);

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callComposite()
        {
            Composite.CPU cp = new Composite.CPU("i7");
            Composite.GraphicCard gc = new Composite.GraphicCard("GTX 900");
            Composite.MotherBoard mb = new Composite.MotherBoard("EVGA Z710 FTW");
            Composite.Bundle b1 = new Composite.Bundle("PC Bundle ");
            Composite.Bundle b2 = new Composite.Bundle("PC Bundle 2");

            b1.addEquipment(cp);
            b1.addEquipment(mb);
            b2.addEquipment(b1);
            b2.addEquipment(gc);

            Console.Write("\nBundle price:" + b2.price);

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
            Observer.Button ok = new Observer.Button();
            Observer.Button cancel = new Observer.Button();

            ok.Attach(new Observer.EntryField());
            cancel.Attach(new Observer.ListBox());

            ok.Click();
            cancel.Click();

            Console.Write("\nEnd");
            Console.ReadLine();
        }

        private static void callMediator()
        {
            Mediator.FrontDialogDirector d = new Mediator.FrontDialogDirector();
            Mediator.Button ok = d.Ok;
            Mediator.Button cancel = d.Cancel;

            ok.Click();
            cancel.Click();

            Console.Write("End");
            Console.ReadLine();

        }
    }
}
