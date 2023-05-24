# Here k represents the size of the subsequence to be chosen
# first of all make pairs of (nums1,nums2) acc. to their index i.e (1,2),(3,1),(3,3) etc. in example 1.
# Than sort the pairs in descending order with respect to second element i.e the order will be (2,4),(3,3),(1,2),(3,1)
# now take first element of all pairs one by one,add it to total variable and append that element to the heap
# continue this until the length of heap is not greater than or equal to k
# as soon as the length of heap = k,take second element of the pair currently chosen and multiply it with total and update that in the variable res which is initially 0.
# At last take max(res,updated res)
class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        total = res = 0
        heap=[]

        pairs=zip(nums1,nums2)

        sorted_pairs = sorted(pairs,key=lambda x: -x[1])

        for pair in sorted_pairs:
            nums1,nums2 = pair

            heappush(heap,nums1)
            total += nums1
 # If the length of the heap exceeds k, remove the smallest element from the heap and update the total
            if len(heap) > k:
                total -= heappop(heap)
# If the length of the heap reaches k, calculate the current score and update the maximum score (res)
            if len(heap) == k:
                res = max(res,total*nums2)

        return res