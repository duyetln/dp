using System;

namespace DesignPatterns.Mediator
{ 
    abstract class WidgetMediator
    {
        public abstract void widgetChanged(Widget widget);
    }

    
    abstract class Widget
    {
        private WidgetMediator _director;

        public Widget(WidgetMediator d)
        {
            _director = d;
        }

        protected void onChange()
        {
            _director.widgetChanged(this);
        }

        // Gets or sets subject state
        public WidgetMediator Mediator
        {
            get { return _director; }
            set { _director = value; }
        }
    }

    class EntryField : Widget
    {
        public EntryField(WidgetMediator d) : base(d) { }

        public void setText(string newText)
        {
            Console.Out.WriteLine("Set Text in EntryField from " + newText);
        }
    }

    class ListBox : Widget
    {
        public ListBox(WidgetMediator d) : base(d) { }

        public void setList(string newText)
        {
            Console.Out.WriteLine("Set List in ListBox from " + newText);
        }
    }



    class Button : Widget
    {
        public Button(WidgetMediator wm) : base(wm) { }

        public void Click()
        {
            onChange();
        }
    }

    
    class FrontDialogDirector : WidgetMediator
    {
        private Button _ok;
        private Button _cancel;
        private EntryField _fontList;
        private ListBox _listbox;

        internal Button Ok
        {
            get
            {
                return _ok;
            }

            set
            {
                _ok = value;
            }
        }

        internal Button Cancel
        {
            get
            {
                return _cancel;
            }

            set
            {
                _cancel = value;
            }
        }

        public FrontDialogDirector()
        {
            Ok = new Button(this);
            Cancel = new Button(this);
            _fontList = new EntryField(this);
            _listbox = new ListBox(this);
        }


        public override void widgetChanged(Widget changedWidget)
        {
            if(changedWidget == Ok)
            {
                _fontList.setText("Ok");
            }
            else if(changedWidget == Cancel)
            {
                _listbox.setList("Cancel");
            }
        }
    }
}
