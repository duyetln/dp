import scala.collection.mutable.ListBuffer

abstract class Equipment(val name : String) {
  def price : Double
}

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

class Purchase(val equipment : Equipment) {
  var pricing : Double => Double = (p : Double) => p
  def total = pricing(equipment.price)
}

val cpu = new CPU("i7")
val gcd = new GraphicCard("GTX 900")
val mbd = new Motherboard("EVGA Z710 FTW")
val bnd = new Bundle("PC Building")
val pur = new Purchase(bnd)
bnd addEquipment cpu
bnd addEquipment gcd
bnd addEquipment mbd
println(pur.total)

val comboPricing = (p : Double) => p * 0.8
pur.pricing = comboPricing
println(pur.total)

val normalPricing = (p : Double) => p
pur.pricing = normalPricing
println(pur.total)

val salePricing = (d : Double) => (p : Double) => p * d
pur.pricing = salePricing(0.3) // curried function; 30% discount
println(pur.total)
