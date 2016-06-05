import scala.collection.mutable.ListBuffer

abstract class Equipment(val name : String) {
  def price : Double
}

object OneItemPricing {
  def calculate(l : ListBuffer[Equipment]) : Double = l(0).price
}

object TwoItemsPricing {
  def calculate(l : ListBuffer[Equipment]) : Double = l.map(e => e.price).max
}

object BundlePricing {
  def calculate(l : ListBuffer[Equipment]) : Double = l.map(e => e.price).sum
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

class Purchase {
  def addEquipment(e : Equipment) {
    if (!(equipments contains e))
      equipments += e
  }

  def removeEquipment(e : Equipment) {
    if (equipments contains e)
      equipments -= e
  }

  def price : Double = {
    if (equipments.size > 2)
      bundlePricing(equipments)
    else if (equipments.size > 1)
      twoItemsPricing(equipments)
    else if (equipments.size > 0)
      oneItemPricing(equipments)
    else
      0
  }

  val equipments = new ListBuffer[Equipment]()
  protected val oneItemPricing = (l : ListBuffer[Equipment]) => l(0).price
  protected val twoItemsPricing = (l : ListBuffer[Equipment]) => l.map(e => e.price).max
  protected val bundlePricing = (l : ListBuffer[Equipment]) => l.map(e => e.price).sum
}

val cpu = new CPU("i7")
val gcd = new GraphicCard("GTX 900")
val mbd = new Motherboard("EVGA Z710 FTW")
val pur = new Purchase

println(pur.price)
pur.addEquipment(cpu)
println(pur.price)
pur.addEquipment(gcd)
println(pur.price)
pur.addEquipment(mbd)
println(pur.price)
