class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        self.b=big
        self.m=medium
        self.s=small

    def addCar(self, c: int) -> bool:
        if c==1:
            if self.b:
                self.b-=1
                return True
        elif c==2:
            if self.m:
                self.m-=1
                return True
        else:
            if self.s:
                self.s-=1
                return True
        return False


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)