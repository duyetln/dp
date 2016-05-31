using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Mediator
{ 
    /// <summary>
    /// The 'ConcreteSubject' class
    /// </summary>
    class Widget
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
        _director.onChange(this);
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

    class Button : Widget
    {
        public Button(DialogDirector d) : base(d) { }

        public new void Click()
        {
            onChange();
            base.Click();
        }
    }

    
    abstract class DialogDirector
    {
        public abstract void createWidget();

        public abstract void onChange(Widget widget);
    }



    class FontDialogDirector : DialogDirector
    {
        private Button _ok;
        private Button _cancel;
        private EntryField _fontList;

        public override void onChange(Widget changed)
    {
            if (changed == _ok)
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
