# If the knight is at (i,j),then the possible coordinates it can move are:
# (i-2,j-1),(i-2,j+1),(i-1,j+2),(i+1,j+2),(i+2,j+1),(i+2,j-1),(i+1,j-2),(i-1,j-2)

# 1.Recursive approach(TLE)
# class Solution:
#     def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
#         return self.find(n, k, row, column)

#     def find(self, N, K, r, c):
#         if not self.isValid(r, c, N):
#             return 0
#         if K == 0:
#             return 1

#         probability = 0
#         dir = [(-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1)]

#         for i in range(len(dir)):
#             probability += self.find(N, K - 1, r + dir[i][0], c + dir[i][1]) / 8.0

#         return probability

#     def isValid(self, r, c, N):
#         if r < 0 or r >= N or c < 0 or c >= N:
#             return False
#         return True

# 2.DP with Memoisation
class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        memo = [[[-1 for _ in range(k+1)] for _ in range(n)] for _ in range(n)]
        return self.find(n, k, row, column, memo)

    def find(self, N, K, r, c, memo):
        if not self.isValid(r, c, N):
            return 0
        if K == 0:
            return 1

        if memo[r][c][K] != -1:
            return memo[r][c][K]

        probability = 0
        dir = [(-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1)]

        for i in range(len(dir)):
            probability += self.find(N, K - 1, r + dir[i][0], c + dir[i][1], memo) / 8.0

        memo[r][c][K] = probability
        return probability

    def isValid(self, r, c, N):
        if r < 0 or r >= N or c < 0 or c >= N:
            return False
        return True
