abstract class GameItem {
  def draw
  def move
  def click
}

abstract class GameItemThread extends Runnable {
  var suspended: Boolean
  def run
}

class Mediator {
  var item: GameItem = null
  var thread: GameItemThread = null

  def click {
    this synchronized {
      println("Click")
      thread.suspended = false
      this.notifyAll
      this.wait
    }
  }

  def run {
    this synchronized {
      if (thread.suspended)
        this.wait

      Thread sleep 500
      item.draw
      item.move
      thread.suspended = true
      this.notifyAll
      this.wait
    }
  }
}

class BallThread extends GameItemThread {
  private var med: Mediator = null
  var suspended = true

  def this(m: Mediator) {
    this()
    med = m
    m.thread = this
  }

  def run {
    while(true)
      med.run
  }
}

class BallItem extends GameItem {
  private var med: Mediator = null

  def this(m: Mediator) {
    this()
    med = m
    m.item = this
  }

  def draw { println("Draw") }
  def move { println("Move") }
  def click { med.click }
}

val m = new Mediator
val b = new BallItem(m)
val t = new BallThread(m)

new Thread(t).start
while (true) {
  if (scala.util.Random.nextInt(100) % 5 == 0)
    b.click
}
