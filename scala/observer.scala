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

class ClockTimer extends Subject {
  def tick {
    println("tick")
    notifyObservers
  }
}

class DigitalClock(val timer : ClockTimer) extends Observer {
  def update(subj : AnyRef) {
    if (subj eq timer)
      println("digital clock updated")
  }
}

class AnalogClock(val timer : ClockTimer) extends Observer {
  def update(subj : AnyRef) {
    if (subj eq timer)
      println("analog clock updated")
  }
}

val timer = new ClockTimer
timer attachObserver (new DigitalClock(timer))
timer attachObserver (new AnalogClock(timer))
1 to 5 foreach { _ => timer.tick }
