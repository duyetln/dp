using System;
using System.Collections.Generic;
using System.Linq;

namespace DesignPatterns.Observer
{
    abstract class Observer
    {
        public abstract void Update(Subject name);//String arg
    }

    abstract class Subject
    {
        private List<Observer> _observers = new List<Observer>();

        public void Attach(Observer observer)
        {
            _observers.Add(observer);
        }

        public void Detach(Observer observer)
        {
            _observers.Remove(observer);
        }

        public void Notify()
        {
            _observers.ForEach(p => p.Update(this));         
        }
    }

    class Button : Subject
    {
        public void Click()
        {
            base.Notify();
        }
    }

    class ListBox : Observer
    {
        public void setList()
        {
            Console.Out.WriteLine("Listbox updated from Button");
        }

        public override void Update(Subject subject)
        {
            if (subject.GetType().Name.Equals("Button"))
                setList();
        }
    }

    class EntryField : Observer
    {
        public void setText()
        {
            Console.Out.WriteLine("EntryField updated from Button");
        }

        public override void Update(Subject subject)
        {
            if (subject.GetType().Name.Equals("Button"))
                setText();
        }
    }

}
