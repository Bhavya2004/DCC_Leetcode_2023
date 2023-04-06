class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        seen = [[False]*m for i in range(n)]
        def dfs(x, y):
            seen[x][y] = True
            for i, j in [(x-1, y), (x+1, y), (x, y-1), (x, y+1)]:
                if 0<=i<n and 0<=j<m and not seen[i][j] and grid[i][j] == 0:
                    dfs(i, j)
        for i in range(n):
            for j in range(m):
                if (i == 0 or i == n-1 or j == 0 or j == m-1) and grid[i][j] == 0 and not seen[i][j]:
                    dfs(i, j)
        ans = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0 and not seen[i][j]:
                    dfs(i, j)
                    ans += 1
        return ans