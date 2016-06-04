'An Observer implementation of the DialogDirector program'

class Observer:
    def update(self, ref):
        pass

class Subject:
    
    def __init__(self):
        self.obs = []
    
    def attachObserver(self, ob):
        if ob not in self.obs:
            self.obs.append(ob)

    def detachObserver(self, ob):
        if ob in self.obs:
            self.obs.remove(ob)
            
    def notifyObservers(self):
        for ob in self.obs:
            ob.update(self)
            

class Button(Subject):
    def click(self):
        print "click"
        self.notifyObservers()


class ListBox(Observer):
    def __init__(self, b):
        self.button = b
    
    def setList(self):
        print "set list"
        
    def update(self, ref):
        if ref == self.button:
            self.setList()

class EntryField(Observer):
    def __init__(self, b):
        self.button = b
        
    def setText(self):
        print "set text"
        
    def update(self, ref):
        if ref == self.button:
            self.setText()
            

ok = Button()
cancel = Button()
ok.attachObserver(EntryField(ok))
cancel.attachObserver(ListBox(cancel))
ok.click()
cancel.click()
