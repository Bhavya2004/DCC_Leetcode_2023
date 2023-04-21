#create a 2d matrix where no. of rows = minprofit+1 and no. of columns= n+1
class Solution:
    def profitableSchemes(self, n: int, minProfit: int, group: List[int], profit: List[int]) -> int:
        MOD = 10**9 + 7
        
        dp = [[0] * (n+1) for i in range(minProfit+1)]
        # dp[i][j] represents the number of profitable schemes with i profits and j members

        dp[0][0] = 1
        # Initialize the base case where there is no profit and no members

        for g, p in zip(group, profit):
            # Iterate through the list of crimes

            for i in range(minProfit, -1, -1):
                # Iterate through the possible profits in reverse order

                for j in range(n-g, -1, -1):
                    # Iterate through the possible numbers of members in reverse order

                    dp[min(i+p, minProfit)][j+g] += dp[i][j]
                    # If the crime is committed, update the number of profitable schemes for the resulting profits and number of members

        return sum(dp[-1]) % MOD