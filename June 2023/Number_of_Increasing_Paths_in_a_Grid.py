class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        n,m=len(grid),len(grid[0])
        dp=[[-1]*m for i in range(n)]
        def f(i,j):
            if dp[i][j]!=-1:
                return dp[i][j]
            s=1
            mod=10**9+7
            if 0<=i-1<len(dp) and 0<=j<len(dp[0]) and grid[i-1][j]>grid[i][j]:
                s=(s+f(i-1,j))%mod
            if 0<=i<len(dp) and 0<=j-1<len(dp[0]) and grid[i][j-1]>grid[i][j]:
                s=(s+f(i,j-1))%mod
            if 0<=i+1<len(dp) and 0<=j<len(dp[0]) and grid[i+1][j]>grid[i][j]:
                s=(s+f(i+1,j))%mod
            if 0<=i<len(dp) and 0<=j+1<len(dp[0]) and grid[i][j+1]>grid[i][j]:
                s=(s+f(i,j+1))%mod
            dp[i][j]=s
            return s
        s=0
        mod=10**9+7
        for i in range(n):
            for j in range(m):
                s=(s+f(i,j))%mod
        return s