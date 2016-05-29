'A Mediator implementation of the DialogDirector program'

class DialogDirector:

    def __init__(self):
         pass

    def ShowDialog(self):
        # show dialog
        pass

    def WidgetChanged(self, Widget):
        # do a thing based on widget change
        pass

    def CreateWidgets(self):
        pass


class Widget:

    DialogDirector = None

    def __init__(self, DialogDirector):
        self.DialogDirector = DialogDirector

    def Changed(self):
        self.DialogDirector.WidgetChanged(self)

    def HandleMouse(self, MouseEvent, Event):
        # respond to user's mouse input
        pass

class ListBox(Widget):

    def GetSelection(self):
        char = None
        return char

    def HandleMouse(self, MouseEvent, Event):
        pass

class EntryField(Widget):

    def SetText(self, text):
        # set text
        pass

    def GetText(self):
        # return selected text
        char = None
        return char

    def HandleMouse(self, MouseEvent, Event):
        pass

class Button(Widget):

    def SetText(self, text):
        # set text
        pass

    def HandleMouse(self, MouseEvent, Event):
        pass


class FontDialogDirector(DialogDirector):

    def __init__(self):
        DialogDirector.__init__(self)

    def CreateWidgets(self):
        self.ok = Button(self)
        self.cancel = Button(self)
        self.fontList = ListBox(self)
        self.fontName = EntryField(self)

    def WidgetChanged(self, changedWidget):
        if changedWidget == self.fontList:
            self.fontName.SetText(self.fontList.GetSelection())
        elif changedWidget == self.ok:
            # apply font change, dismiss dialog
            pass
        elif changedWidget == self.cancel:
            # dismiss dialog
            pass


