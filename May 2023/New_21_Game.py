# Question:
# Alice starts with 0 points and her goal is to accumulate points without exceeding a certain threshold, which is represented by the variable 'k'. During each turn, Alice draws a random number of points from the range of 1 to 'maxPts'. The 'maxPts' variable represents the maximum number of points Alice can gain in a single draw.
# The task is to calculate the probability that Alice has 'n' or fewer points when she stops drawing.
class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        if k == 0 or n >= k + maxPts:
            return 1.0
        
        dp = [0.0] * (n + 1)
        dp[0] = 1.0
        window_sum = 1.0
        
        for i in range(1, n + 1):
            dp[i] = window_sum / maxPts
            if i < k:
                window_sum += dp[i]
            if i - maxPts >= 0:
                window_sum -= dp[i - maxPts]
        
        return sum(dp[k:])