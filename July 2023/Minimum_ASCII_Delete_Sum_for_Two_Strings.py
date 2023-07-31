class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        @lru_cache(None)
        def dp(i, j):
            if i == m and j == n:
                return 0
            elif i == m:
                return ord(s2[j]) + dp(i, j+1)
            elif j == n:
                return ord(s1[i]) + dp(i+1, j)
            
            if s1[i] != s2[j]:
                return min(ord(s1[i]) + dp(i+1, j), ord(s2[j]) + dp(i, j+1))
            else:
                return dp(i+1, j+1)            
        
        return dp(0, 0)
