abstract class DialogDirector {
  def widgetChanged(widget : AnyRef)
}

abstract class Widget(val director : DialogDirector) {
  def changed {
    director.widgetChanged(this)
  }
}

class ListBox(director : DialogDirector) extends Widget(director) {
  def setList {
    println("setList")
  }
}

class EntryField(director : DialogDirector) extends Widget(director) {
  def setText {
    println("setText")
  }
}

class Button(director : DialogDirector) extends Widget(director) {
  def click {
    println("click")
    changed
  }
}

class FrontDialogDirector extends DialogDirector {
  val ok = new Button(this)
  val cancel = new Button(this)
  val box = new ListBox(this)
  val entry = new EntryField(this)

  def widgetChanged(widget : AnyRef) {
    if (widget eq ok)
      entry.setText
    else if (widget eq cancel)
      box.setList
  }
}

val director = new FrontDialogDirector
val ok = director.ok
val cancel = director.cancel
ok.click
cancel.click
