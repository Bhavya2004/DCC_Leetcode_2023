class Solution(object):
    def PredictTheWinner(self, nums):

        dp = {}

        def find(i, j):
            if (i, j) not in dp:
                if i == j:
                    return nums[i]
                dp[i,j] = max(nums[i]-find(i+1, j), nums[j]-find(i, j-1))
            return dp[i,j]

        return find(0, len(nums)-1) >= 0