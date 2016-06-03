'A Mediator implementation of the DialogDirector program'

class DialogDirector:

    def WidgetChanged(self, Widget):
        # do a thing based on widget change
        pass


class Widget:

    def __init__(self, DialogDirector):
        self.DialogDirector = DialogDirector

    def Changed(self):
        self.DialogDirector.WidgetChanged(self)


class ListBox(Widget):
    
    def SetList(self):
        print "set list"


class EntryField(Widget):

    def SetText(self):
        print "set text"


class Button(Widget):

    def Click(self):
        print "click"


class FontDialogDirector(DialogDirector):

    ok = Button(self)
    cancel = Button(self)
    box = ListBox(self)
    entry = EntryField(self)

    def WidgetChanged(self, changedWidget):
        if changedWidget == self.ok:
            entry.SetList()
        elif changedWidget == self.cancel:
            box.SetList()


director = new FrontDialogDirector()
ok  = director.ok
cancel = director.cancel
ok.click
cancel.click
