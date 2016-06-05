"""Implementation of Equipment Program using Strategy design pattern"""

class Equipment:
    def __init__(self, name):
        self.name = name

    def price(self):
        pass


def normalPrice(e):
    return e[0].price()

def twoForOnePrice(e):
    if e[0].price() > e[1].price():
        return e[0].price()
    else:
        return e[1].price()

def bundlePricing(e):
    sum = 0.
    for i in e:
        sum += i.price()
    return sum*0.8


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
    def __init__(self, name):
        self.name = name
        self. Equipment = []

    def addEquipment(self, e):
        if e not in self.Equipment:
            self.Equipment.append(e)

    def removeEquipment(self, e):
        if e in self.Equipment:
            self.Equipment.remove(e)

    def total(self):
        if len(self.Equipment) == 1:
            return normalPrice(self.Equipment)
        elif len(self.Equipment) == 2:
            return twoForOnePrice(self.Equipment)
        else:
            return bundlePricing(self.Equipment)

####################################################

cpu = CPU("i7")
gcd = GraphicsCard("GTX 900")
mbd = Motherboard("EVGA Z710 FTW")

pur = Purchase("My PC Build")

pur.addEquipment(cpu)
pur.addEquipment(gcd)
pur.addEquipment(mbd)

print pur.total()

