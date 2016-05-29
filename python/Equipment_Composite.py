"""Equipment"""

class Equipment:

    Equipment = []

    def __init__(self, name, power=None, netPrice = None, discountPrice=None):
        self.name = name
        self.power = power
        self.netPrice = netPrice
        self.discountPrice = discountPrice

    def Power(self):
        return self.Power
    def NetPrice(self):
        return self.NetPrice
    def DiscountPrice(self):
        return self.discountPrice

    def Add(self, Equipment):
        self.Equipment.append(Equipment)

    def Remove(self, Equipment):
        self.Equipment.remove(Equipment)


class FloppyDisk(Equipment):
    pass

class Cabinet(Equipment):
    pass

class Chassis(Equipment):
    pass

class Bus(Equipment):
    pass

class Card(Equipment):
    pass


cabinet = Cabinet("PC Cabinet")
chassis = Chassis("PC Chassis")

cabinet.Add(chassis)

bus = Bus("MCA Bus")
bus.Add(Card("16Mbs Token Ring"))

chassis.Add(bus)
chassis.Add(FloppyDisk("3.5in Floppy"))