abstract class Equipment(val name : String) {
  def power : Double
  def price : Double
}

class CompositeEquipment(name : String) extends Equipment(name) {
  def power : Double = equipments.map(e => e.power).sum
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
  def power : Double = 120
  def price : Double = 45
}

class CPU(name : String) extends Equipment(name) {
  def power : Double = 15
  def price : Double = 75
}

class Motherboard(name : String) extends CompositeEquipment(name) {
}

val cpu = new CPU("i7")
val gcd = new GraphicCard("GTX 900")
val mbd = new Motherboard("EVGA Z710 FTW")
mbd addEquipment cpu
mbd addEquipment gcd
println(mbd.power)
println(mbd.price)
