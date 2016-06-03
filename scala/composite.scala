import scala.collection.mutable.ListBuffer

abstract class Equipment(val name : String) {
  def price : Double
}

class CompositeEquipment(name : String) extends Equipment(name) {
  def price : Double = equipments.map(e => e.price).sum
  def addEquipment(e : Equipment) {
    if (!(equipments contains e))
      equipments += e
  }

  def removeEquipment(e : Equipment) {
    if (equipments contains e)
      equipments -= e
  }

  protected val equipments = new ListBuffer[Equipment]()
}

class GraphicCard(name : String) extends Equipment(name) {
  def price : Double = 45
}

class CPU(name : String) extends Equipment(name) {
  def price : Double = 75
}

class Motherboard(name : String) extends CompositeEquipment(name) {
}

val cpu = new CPU("i7")
val gcd = new GraphicCard("GTX 900")
val mbd = new Motherboard("EVGA Z710 FTW")
mbd addEquipment cpu
mbd addEquipment gcd
println(mbd.price)
