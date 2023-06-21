class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        
        def calculate_cost(l):
            total_cost = 0
            for i, x in enumerate(nums):
                total_cost += abs(l - x) * cost[i]
            return total_cost
        
  
        left = min(nums)
        right = max(nums) + 1
        mid = (left + right) // 2
        
        while left < right:
            if calculate_cost(mid) < calculate_cost(mid + 1):
                right = mid
            else:
                left = mid + 1
            mid = (left + right) // 2
        
        return calculate_cost(left)