class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        mod=10**9+7
        dp=[1]
        total=0

        for i in range(1,high+1):
            dp.append(0)

            if i-zero>=0:
                dp[i]+=dp[i-zero]

            if i-one>=0:
                dp[i]+=dp[i-one]

            dp[i]%=mod

            if low<=i<=high:
                total+=dp[i]
                total%=mod

        return total%mod                