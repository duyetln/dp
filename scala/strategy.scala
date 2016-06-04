import scala.collection.mutable.ListBuffer

abstract class Pricing {
  def calculate(p : Double) : Double
}

class NormalPricing extends Pricing {
  def calculate(p : Double) : Double = p
}

class ComboPricing extends Pricing {
  def calculate(p : Double) : Double = p * 0.8
}

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
  var pricing : Pricing = new NormalPricing
  def total = pricing calculate (equipment.price)
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

pur.pricing = new ComboPricing
println(pur.total)

pur.pricing = new NormalPricing
println(pur.total)
