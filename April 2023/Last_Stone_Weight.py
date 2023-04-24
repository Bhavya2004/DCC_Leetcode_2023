# take 2 stones at a time.If they are equal,don't take them and move to next.And if they are not equal take the diff between both the stones and append the ans in stones[].
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # Create a max heap with negative stone weights for easy popping of heaviest stones.
        max_heap=[-i for i in stones]
        heapq.heapify(max_heap)

        # Smash stones together until there is only one or no stones left.
        while len(max_heap) > 1:
            x=heapq.heappop(max_heap) # Get the heaviest stone.
            y=heapq.heappop(max_heap) # Get the second heaviest stone.

            if x != y: # If the stones have different weights, then destroy the lighter stone.
                heapq.heappush(max_heap, x-y) # Push the difference of the weights back into the max heap.

        # If there is a stone left in the heap, return its weight (negative due to max heap).
        if max_heap:
            return -max_heap[0]
        # Otherwise, return 0.
        return 0