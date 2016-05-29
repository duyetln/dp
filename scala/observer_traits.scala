import scala.collection.mutable.ListBuffer

trait Subject[T] {
  self: T =>
  def attachObserver(ob : T => Unit) {
    if (!(obs contains ob))
      obs += ob
  }

  def detachObserver(ob : T => Unit) {
    if (obs contains ob)
      obs -= ob
  }

  def notifyObservers() {
    for (ob <- obs)
      ob(this)
  }

  protected val obs = new ListBuffer[T => Unit]()
}

class Button {
  def click {
    println("click")
  }
}

class ListBox {
  def setList {
    println("setList")
  }

  def update(b : Button) {
    setList
  }
}

class EntryField {
  def setText {
    println("setText")
  }

  def update(b : Button) {
    setText
  }
}

trait ButtonSubject extends Button with Subject[Button] {
  override def click {
    super.click
    notifyObservers
  }
}

val ok = new Button with ButtonSubject
val cancel = new Button with ButtonSubject
ok attachObserver (new EntryField().update)
cancel attachObserver (new ListBox().update)
ok.click
cancel.click
