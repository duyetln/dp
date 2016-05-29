class ListBox {
  def setList {
    println("setList")
  }
}

class EntryField {
  def setText {
    println("setText")
  }
}

class Button {
  def click {
    println("click")
  }
}

class FrontDialogDirector {
  val ok = new Button with OkButton
  val cancel = new Button with CancelButton
  val box = new ListBox
  val entry = new EntryField

  protected trait OkButton extends Button {
    override def click {
      super.click
      entry.setText
    }
  }

  protected trait CancelButton extends Button {
    override def click {
      super.click
      box.setList
    }
  }
}

val director = new FrontDialogDirector
val ok = director.ok
val cancel = director.cancel
ok.click
cancel.click
