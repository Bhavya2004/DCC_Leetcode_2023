class Solution(object):
    def generateMatrix(self, n):
        mat = [[0 for i in range(n)] for j in range(n)]
        visited = set()
        DIR = [0, 1, 0, -1, 0]
        num, x, y, d = 1, 0, 0, 0
        
        for num in range(1, n*n+1):
            mat[x][y] = num
            visited.add((x, y))
            nx, ny = x + DIR[d], y + DIR[d+1]
            if not 0 <= nx < n or not 0 <= ny < n or (nx, ny) in visited:
                d = (d+1) % 4
            x, y = x + DIR[d], y + DIR[d+1]
        
        return mat