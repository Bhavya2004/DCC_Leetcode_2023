class Solution:
    def mincostTickets(self, days, costs):
    
        dp = [0] * 366
        travel_days = set(days)
        for i in range(1, 366):
            if i not in travel_days:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(dp[i-1] + costs[0], dp[max(0, i-7)] + costs[1], dp[max(0, i-30)] + costs[2])
        return dp[365]