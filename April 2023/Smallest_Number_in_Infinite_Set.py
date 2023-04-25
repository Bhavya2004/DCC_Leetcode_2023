import heapq
class SmallestInfiniteSet:

    def __init__(self):
        self.min_num = 1
        self.heap=[]

    def popSmallest(self) -> int:
        if self.heap:   #means if heap is not empty
            return heapq.heappop(self.heap)
        self.min_num += 1
        return self.min_num - 1
        

    def addBack(self, num: int) -> None:
        if self.min_num > num and num not in self.heap:
            heapq.heappush(self.heap,num)
        


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)