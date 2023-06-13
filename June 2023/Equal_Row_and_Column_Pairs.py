# I have used nested loops to compare every row against every column.
class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        n = len(grid)
        count = 0

        for i in range(n):
            for j in range(n):
                row = grid[i]
                col = [grid[k][j] for k in range(n)]
                if row == col:
                    count += 1

        return count