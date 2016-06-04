abstract class Widget {
}

class ListBox extends Widget {
  def setList {
    println("setList")
  }
}

class EntryField extends Widget {
  def setText {
    println("setText")
  }
}

class Button extends Widget {
  def click {
    println("click")
  }
}

class FrontDialogMediator {
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

val director = new FrontDialogMediator
val ok = director.ok
val cancel = director.cancel
ok.click
cancel.click
