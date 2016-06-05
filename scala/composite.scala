import scala.collection.mutable.ListBuffer

abstract class Equipment(val name : String) {
  def price : Double
}

// Composite equipment
class Bundle(name : String) extends Equipment(name) {
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

class Motherboard(name : String) extends Equipment(name) {
  def price : Double = 150
}

val cpu = new CPU("i7")
val gcd = new GraphicCard("GTX 900")
val mbd = new Motherboard("EVGA Z710 FTW")
val b1 = new Bundle("PC Building")
val b2 = new Bundle("Gaming PC Building")
b1 addEquipment cpu
b1 addEquipment mbd
b2 addEquipment b1
b2 addEquipment gcd
println(b2.price)
