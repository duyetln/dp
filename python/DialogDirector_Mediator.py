'A Mediator implementation of the DialogDirector program'

class DialogDirector:

    def WidgetChanged(self, Widget):
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

    def click(self):
        print "click"
        self.Changed()


class FontDialogDirector(DialogDirector):

    def __init__(self):
        self.ok = Button(self)
        self.cancel = Button(self)
        self.box = ListBox(self)
        self.entry = EntryField(self)

    def WidgetChanged(self, changedWidget):
        if changedWidget == self.ok:
            self.box.SetList()
        elif changedWidget == self.cancel:
            self.entry.SetText()


###############################################

director = FontDialogDirector()
ok = director.ok
cancel = director.cancel
ok.click()
cancel.click()
