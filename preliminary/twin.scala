abstract class GameItem {
  def draw
  def move
  def click
}

abstract class GameItemThread extends Runnable {
  var suspended: Boolean
  def run
}

class BallThread extends GameItemThread {
  var twin: GameItem = null
  var lock: Object = null
  var suspended = true

  def run {
    while(true) {
      lock synchronized {
        if (suspended)
          lock.wait

        Thread sleep 500
        twin.draw
        twin.move
        suspended = true
        lock.notifyAll
        lock.wait
      }
    }
  }
}

class BallItem extends GameItem {
  var twin: GameItemThread = null
  var lock: Object = null

  def draw { println("Draw") }
  def move { println("Move") }
  def click {
    lock synchronized {
      println("Click")
      twin.suspended = false
      lock.notifyAll
      lock.wait
    }
  }
}

val b = new BallItem
val t = new BallThread
val l = new Object

b.twin = t
t.twin = b
b.lock = l
t.lock = l

new Thread(t).start
while (true) {
  if (scala.util.Random.nextInt(100) % 5 == 0)
    b.click
}
