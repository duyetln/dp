'An Observer implementation of the DialogDirector program'

class DialogBox:

    observers = []

    def __init__(self):
         pass

    def ShowDialog(self):
        # show dialog
        pass

    def attach(self, obs):
        if obs not in self.observers:
            self.observers.append(obs)

    def detach(self, obs):
        if obs in self.observers:
            self.observers.remove(obs)

    def notify(self):
        for obs in self.observers:
            obs.update()

    def update(self):
        # do a thing, based on notification from observed object
        pass


class Widget:

    observers = []

    def __init__(self, obs=None):
        self.attach(obs)

    def HandleMouse(self, MouseEvent, Event):
        # abstract method, to be overriden by subclasses
        pass

    def attach(self, obs):
        if obs not in self.observers:
            self.observers.append(obs)

    def detach(self, obs):
        if obs in self.observers:
            self.observers.remove(obs)

    def notify(self, type=None):
        for obs in self.observers:
            obs.update()

    def update(self):
        # do a thing, based on notification from observed object
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


class FontDialogBox(DialogBox):

    def __init__(self):
        DialogBox.__init__(self)

    def update(self, type=None):
        if type == "approved":
            # apply font change, dismiss
            pass
        elif type == "cancelled":
            # dismiss
            pass


class ok(Button):
    def update(self):
        self.notify("approved") # notify FontDialogBox, which will apply font change and close itself
        pass

class cancel(Button):
    def update(self):
        self.notify("cancelled") # notify FontDialogBox, which will close itself
        pass

class fontList(ListBox):
    def update(self):
        ##
        pass

class fontName(EntryField):
    def update(self):
        self.SetText(fontList.GetSelection())
        pass

fontDialogBox = FontDialogBox()
ok = ok()
cancel = cancel()
fontList = fontList()
fontName = fontName()

ok.attach(fontDialogBox)
cancel.attach(fontDialogBox)
fontList.attach(fontName)

