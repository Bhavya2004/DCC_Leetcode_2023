class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        low, high = 0, row*col
        a = [[0 for i in range(col)] for j in range(row)]
        for i in range(row*col):
            a[cells[i][0]-1][cells[i][1]-1] = i+1
        while low != high:
            mid = (low+high+1) >> 1
            seen = [[False for i in range(col)] for j in range(row)]
            def dfs(x, y):
                seen[x][y] = True
                for i, j in [(x-1, y), (x+1, y), (x, y-1), (x, y+1)]:
                    if 0<=i<row and 0<=j<col and a[i][j] > mid and not seen[i][j]:
                        dfs(i, j)
            for i in range(col):
                if a[0][i] > mid and not seen[0][i]:
                    dfs(0, i)
            if any(seen[-1]):
                low = mid
            else:
                high = mid-1
        return low