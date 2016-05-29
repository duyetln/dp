import scala.collection.mutable.ListBuffer

abstract class Observer {
  def update(subj : AnyRef)
}

abstract class Subject {
  def attachObserver(ob : Observer) {
    if (!(obs contains ob))
      obs += ob
  }

  def detachObserver(ob : Observer) {
    if (obs contains ob)
      obs -= ob
  }

  def notifyObservers() {
    for (ob <- obs)
      ob update this
  }

  protected val obs = new ListBuffer[Observer]()
}

class Button extends Subject {
  def click {
    println("click")
    notifyObservers
  }
}

class ListBox(val button : Button) extends Observer {
  def setList {
    println("setList")
  }

  def update(subj : AnyRef) {
    if (subj eq button)
      setList
  }
}

class EntryField(val button : Button) extends Observer {
  def setText {
    println("setText")
  }

  def update(subj : AnyRef) {
    if (subj eq button)
      setText
  }
}

val ok = new Button
val cancel = new Button
ok attachObserver (new EntryField(ok))
cancel attachObserver (new ListBox(cancel))
ok.click
cancel.click
