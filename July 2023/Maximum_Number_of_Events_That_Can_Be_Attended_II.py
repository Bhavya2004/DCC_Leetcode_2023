class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        events.sort(key=lambda ans:ans[1])
        dp=[[0,0]]
        dp2=[[0,0]]
        for x in range(k):
            for s,e,v in events:
                i=bisect.bisect(dp,[s])-1
                if dp[i][1]+v>dp2[-1][1]:
                    dp2.append([e,dp[i][1]+v])

            dp=dp2
            dp2=[[0,0]]

        return dp[-1][-1]    