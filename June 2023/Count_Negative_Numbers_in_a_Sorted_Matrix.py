class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        count = 0
        for row in grid:
            for num in row:
                if num < 0:
                    count += 1
        return count