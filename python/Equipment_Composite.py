"""Equipment"""

class Equipment:
    
    def __init__(self, name, price, power):
    self.name = name
    self.power = power
    self.price = price
    

Class CompositeEquipment(Equipment):
    Equipment = []
        
    def Power(self):
        sum = 0.
        for e in self.Equipment:
            sum += e.power
        self.Power = sum
        return self.Power
        
    def Price(self):
        sum = 0.
        for e in self.Equipment:
            sum += e.power
        self.Power = sum
        return self.Power

    def Add(self, e):
        if e not in self.Equipment:
            self.Equipment.append(e)

    def Remove(self, e):
        if e in self.Equipment:
            self.Equipment.remove(e)


class GraphicsCard(Equipment):
   def __init__(self, name):
       self.name = name
       self.price = 45.
       self.power = 120.

class CPU(Equipment):
    def __init__(self, name):
       self.name = name
       self.price = 75.
       self.power = 15.

class Motherboard(CompositeEquipment):
    def __init__(self, name):
        self.name = name

cpu = CPU("i7")
gcd = GraphicsCard("GTX 900")
mbd = Motherboard("EVGA Z710 FTW")

mbd.Add(cpu)
mbd.Add(gcd)
print mbd.Power
print mbd.Price
