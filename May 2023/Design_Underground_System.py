class UndergroundSystem:

    def __init__(self):
        self.I,self.P,self.F={},Counter(),Counter()
        

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.I[id]=stationName,t
        

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        u,v=self.I.pop(id)
        self.P[(u,stationName)]+=t-v
        self.F[(u,stationName)]+=1
        

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        return self.P[startStation,endStation]/self.F[startStation,endStation]
        


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)