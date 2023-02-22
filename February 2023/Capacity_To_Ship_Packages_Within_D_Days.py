#Used binary search
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        
        lo, hi = max(weights), sum(weights)
        while lo < hi:
            mid = (lo + hi) // 2
            curr_weight, curr_days = 0, 1 #i have set days=1 as min 1 day will be required 
            for w in weights:
                if curr_weight + w > mid:
                    curr_weight = w
                    curr_days += 1
                else:
                    curr_weight += w
            if curr_days > days:
                lo = mid + 1
            else:
                hi = mid
        return lo