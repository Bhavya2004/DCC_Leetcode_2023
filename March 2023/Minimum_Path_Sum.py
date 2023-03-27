class Solution:
    def minPathSum(self, g: List[List[int]]) -> int:
        n, m = len(g), len(g[0])
        @cache
        def ans(x, y):
            if x == n-1 and y == m-1:
                return g[x][y]
            if x == n-1:
                return g[x][y]+ans(x, y+1)
            if y == m-1:
                return g[x][y]+ans(x+1, y)
            return g[x][y]+min(ans(x+1, y), ans(x, y+1))
        return ans(0, 0)