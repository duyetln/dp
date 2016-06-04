"""Implementation of Equipment Program using Strategy design pattern"""


class Pricing:

    def __init__(self):
        pass

    def calculate(self, p):
        pass


class NormalPricing(Pricing):
    def calculate(self, p):
        return p


class ComboPricing(Pricing):
    def calculate(self, p):
        return 0.8*p


class Equipment:

    def __init__(self, name):
        self.name = name

    def price(self):
        pass


class Bundle(Equipment):

    Equipment = []

    def price(self):
        sum = 0.
        for e in self.Equipment:
            sum += e.price()
        return sum

    def addEquipment(self, e):
        if e not in self.Equipment:
            self.Equipment.append(e)

    def removeEquipment(self, e):
        if e in self.Equipment:
            self.Equipment.remove(e)


class GraphicsCard(Equipment):
    def price(self):
        return 45.

class CPU(Equipment):
    def price(self):
        return 75.

class Motherboard(Equipment):
    def price(self):
        return 150.


class Purchase:

    def __init__(self, equipment):
        self.equipment = equipment
        self.pricing = NormalPricing()

    def total(self):
        return self.pricing.calculate(self.equipment.price())


cpu = CPU("i7")
gcd = GraphicsCard("GTX 900")
mbd = Motherboard("EVGA Z710 FTW")
bnd = Bundle("PC Building")

bnd.addEquipment(cpu)
bnd.addEquipment(gcd)
bnd.addEquipment(mbd)
pur = Purchase(bnd)
print pur.total()

pur.pricing = ComboPricing()
print pur.total()
