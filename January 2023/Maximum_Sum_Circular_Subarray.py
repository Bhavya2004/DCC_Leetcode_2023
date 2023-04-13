class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        maxx, minn, summ, currMax, currMin = -math.inf, math.inf, 0, -math.inf, math.inf
        for n in nums:
            summ += n
            currMax = max(currMax + n, n)
            maxx = max(maxx, currMax)
            currMin = min(currMin + n, n)
            minn = min(minn, currMin)
        return max(maxx, summ - minn) if maxx > 0 else maxx