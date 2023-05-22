# We have to find top k repeated elements from nums.For e.g in example 1 we have to fond k i.e 2 topvfrequent elements.So in that 1 appears 3 times,2 appears 2 times and 3 appears 1 time.So return 1 and 2.
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = Counter(nums)
        heap=[]

        for num,freq in d.items():
            heapq.heappush(heap,(-freq,num))

        res=[]

        for _ in range(k):
            res.append(heapq.heappop(heap)[1])

        return res 