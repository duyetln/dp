import scala.collection.mutable.ListBuffer

abstract class Equipment {
}

// Composite equipment
case class Bundle(name : String, equipments : List[Equipment]) extends Equipment {
}

case class GraphicCard(name : String) extends Equipment {
}

case class CPU(name : String) extends Equipment {
}

case class Motherboard(name : String) extends Equipment {
}

val bnd = Bundle("PC Building", List(CPU("i7"), GraphicCard("GTX 900"), Motherboard("EVGA Z710 FTW")))

def price(equipment : Equipment) : Double = {
  equipment match {
    case gcd @ GraphicCard(name) => 75
    case cpu @ CPU(name) => 45
    case mbd @ Motherboard(name) => 150
    case bdl @ Bundle(name, equipments) => equipments.map(e => price(e)).sum
  }
}

println(price(bnd))
