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

class ClockTimer {
  def tick {
    println("tick")
  }
}

class DigitalClock {
  def update(t : ClockTimer) {
    println("digital clock updated")
  }
}

class AnalogClock {
  def update(t : ClockTimer) {
    println("analog clock updated")
  }
}

trait ClockTimerSubject extends ClockTimer with Subject[ClockTimer] {
  override def tick {
    super.tick
    notifyObservers
  }
}

val timer = new ClockTimer with ClockTimerSubject
timer attachObserver (new DigitalClock().update)
timer attachObserver (new AnalogClock().update)
1 to 5 foreach { _ => timer.tick }
