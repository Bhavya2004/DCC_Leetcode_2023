class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heap = []
        for n in nums:
            if len(self.heap) < k:
                heapq.heappush(self.heap, n)
            elif n > self.heap[0]:
                heapq.heapreplace(self.heap, n)
        

    def add(self, val: int) -> int:
        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
            return self.heap[0]
        if val > self.heap[0]:
            heapq.heapreplace(self.heap, val)
        return self.heap[0]
        


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)