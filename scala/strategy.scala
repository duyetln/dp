import scala.collection.mutable.ListBuffer

abstract class Discount {
  def price(p: Double) : Double
}

class FlatDiscount(amount: Double) extends Discount {
  def price(p: Double) = {
    if (p > amount) p - amount else 0
  }
}

class PercentageDiscount(percent : Double) extends Discount {
  def price(p: Double) = {
    if (percent < 1) p * (1 - percent) else 0
  }
}

class NoDiscount extends Discount {
  def price(p: Double) = p
}

abstract class Equipment(val name : String) {
  def price : Double
}

class CompositeEquipment(name : String, val discount : Discount) extends Equipment(name) {
  def price : Double = discount price (equipments.map(e => e.price).sum)
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

class Motherboard(name : String, discount: Discount) extends CompositeEquipment(name, discount) {
}

val cpu1 = new CPU("i7")
val gcd1 = new GraphicCard("GTX 900")
val mbd1 = new Motherboard("EVGA Z710 FTW", new NoDiscount()) // normal price
mbd1 addEquipment cpu1
mbd1 addEquipment gcd1
println(mbd1.price)


val cpu2 = new CPU("i7")
val gcd2 = new GraphicCard("GTX 900")
val salebundle = new Motherboard("EVGA Z710 FTW", new PercentageDiscount(0.3)) // holiday sale
salebundle addEquipment cpu2
salebundle addEquipment gcd2
println(salebundle.price)
