"""Equipment"""

class Equipment:
    
    def __init__(self, name, price):
        self.Name = name
        self.price = price

    def getPrice(self):
        return self.price


class CompositeEquipment(Equipment):
    def __init__(self, name):
        Equipment.__init__(self, name, 0.)
        self.Equipment = []

    def getPrice(self):
        sum = 0.
        for e in self.Equipment:
            sum += e.getPrice()
        self.price = sum
        return self.price

    def Add(self, e):
        if e not in self.Equipment:
            self.Equipment.append(e)

    def Remove(self, e):
        if e in self.Equipment:
            self.Equipment.remove(e)


class GraphicsCard(Equipment):
   def __init__(self, name):
       Equipment.__init__(self, name, 45.)

class CPU(Equipment):
    def __init__(self, name):
        Equipment.__init__(self, name, 75.)


class Motherboard(Equipment):
    def __init__(self, name):
        Equipment.__init__(self, name, 150.)




# cpu = CPU("i7")
# gcd = GraphicsCard("GTX 900")
# mbd = Motherboard("EVGA Z710 FTW")
# bnd = CompositeEquipment("PC Building")
# bnd.Add(cpu)
# bnd.Add(gcd)
# bnd.Add(mbd)

# cpu2 = CPU("i9")
# gcd2 = GraphicsCard("GTX 800")
# mbd2 = Motherboard("EVGA Perl FTW")
# bnd2 = CompositeEquipment("PC Building 2")
# bnd2.Add(cpu2)
# bnd2.Add(gcd2)
# bnd2.Add(mbd2)

# superspecial = CompositeEquipment("Two For One Deal")
# superspecial.Add(bnd)
# superspecial.Add(bnd2)

# print superspecial.getPrice()
