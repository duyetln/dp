using System;
using System.Collections.Generic;

namespace DesignPatterns.Observer
{
    /// <summary>
    /// The 'Subject' abstract class
    /// </summary>
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
            foreach (Observer o in _observers)
            {
                o.Update(this);
            }
        }
    }

    /// <summary>
    /// The 'ConcreteSubject' class
    /// </summary>
    class Widget : Subject
    {
        private DialogDirector _director;

        public Widget(DialogDirector d)
        {
            _director = d;
        }

        protected void Click()
        {
            Console.WriteLine("Click!");
      
        }

        protected void onChange()
        {
            base.Notify();
        }

        // Gets or sets subject state
        public DialogDirector SubjectState
        {
            get { return _director; }
            set { _director = value; }
        }
    }

    class EntryField : Widget
    {
        private string text;

        public EntryField(DialogDirector d) : base(d) { }

        public string Text
        {
            get
            {
                return text;
            }

            set
            {
                text = value;
            }
        }

        public new void Click()
        {
            onChange();
            base.Click();
        }
    }

    class Button: Widget
    {
        public Button(DialogDirector d) : base(d) { }

        public new void Click()
        {
            onChange();
            base.Click();
        }
    }

    /// <summary>
    /// The 'Observer' abstract class
    /// </summary>
    abstract class Observer
    {
        public abstract void Update(Subject name);//String arg
    }

    /// <summary>
    /// The 'ConcreteObserver' class
    /// </summary>
    abstract class DialogDirector : Observer
    {
        public abstract void createWidget();
    }

    class FontDialogDirector : DialogDirector
    { 
        private Button _ok;
        private Button _cancel;
        private EntryField _fontList;

        public override void Update(Subject changed)
        {
            if(changed == _ok)
            {
                Console.Write("Changed List");
            }
            else if (changed == _cancel)
            {
                Console.Write("Cancel List");
            }
            else if (changed == _fontList)
            {
                Console.Write("Set value for the List");
            }
            else
            {
                Console.Write("Unknown op");
            }

        }

        public override void createWidget()
        {
            this._ok = new Button(this);
            this._cancel = new Button(this);
            this._fontList = new EntryField(this);

            //Attch observers
            this._ok.Attach(this);
            this._cancel.Attach(this);
            this._fontList.Attach(this);
        }

        public void pressOk()
        {
            _ok.Click();
        }

        public void pressCancel()
        {
            _cancel.Click();
        }

        public void openFontList()
        {
            _fontList.Click();
        }
    }

    
}
