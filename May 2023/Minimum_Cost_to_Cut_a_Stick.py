class Solution:
    def minCost(self, n, cuts):
        # Append the endpoints of the stick to the cuts array
        cuts.append(0)
        cuts.append(n)
        cuts.sort()
        m = len(cuts)
        
        # Create a 2D array to store the minimum cost of cuts
        dp = [[0] * m for _ in range(m)]

        # Iterate over the lengths of cuts
        # l represents the length of the subarray being considered
        for l in range(2, m):
            # Iterate over the starting positions of the subarray
            for i in range(m - l):
                # Calculate the ending position of the subarray
                j = i + l
                # Initialize the minimum cost for the subarray to infinity
                dp[i][j] = float('inf')
                # Iterate over all possible positions to make a cut within the subarray
                for k in range(i + 1, j):
                    # Update the minimum cost if a new cut produces a lower cost
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + cuts[j] - cuts[i])

        # Return the minimum cost for the entire stick (from position 0 to n)
        return dp[0][m - 1]