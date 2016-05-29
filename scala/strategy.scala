import scala.collection.mutable.ListBuffer

class Item(val name : String, val price : Double)

abstract class Discount {
  def total(price : Double) : Double
}

class FlatDiscount(amount : Double) extends Discount {
  def total(price : Double) = {
    if (price > amount) price - amount else 0
  }
}

class PercentageDiscount(percent : Double) extends Discount {
  def total(price : Double) = {
    if (percent < 1) price * (1 - percent) else 0
  }
}

class NoDiscount extends Discount {
  def total(price : Double) = price
}

class Bill(val discount : Discount = new NoDiscount()) {
  def addItem(item : Item) {
    items += item
  }

  def price : Double = items.map(i => i.price).sum

  def total : Double = {
    discount total price
  }

  protected val items = new ListBuffer[Item]()
}

val b1 = new Bill(new FlatDiscount(5))
val b2 = new Bill(new PercentageDiscount(0.1))
val b3 = new Bill

val i1 = new Item("Lunch", 10)
val i2 = new Item("Dessert", 7.5)
val i3 = new Item("Coffee", 5)

b1 addItem i1
b1 addItem i2
b1 addItem i3
println(b1.total)

b2 addItem i1
b2 addItem i2
b2 addItem i3
println(b2.total)

b3 addItem i1
b3 addItem i2
b3 addItem i3
println(b3.total)


