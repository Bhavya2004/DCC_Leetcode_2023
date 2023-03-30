class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        # recursive approach:(time limit exceeded):
        #  Base cases:
        # if s1==s2:
        #     return True
        # if len(s1)!=len(s2):
        #     return False
        # if sorted(s1)!=sorted(s2):
        #     return False

        #  try all possible swaps
        # for i in range(1, len(s1)):
        # # case 1: don't swap the substrings
        #     if self.isScramble(s1[:i], s2[:i]) and self.isScramble(s1[i:], s2[i:]):
        #         return True
        #  case 2: swap the substrings
        #     if self.isScramble(s1[:i], s2[-i:]) and self.isScramble(s1[i:], s2[:-i]):
        #         return True
        #  none of the splits and swaps worked
        # return False
        
        # dp approach:
        n = len(s1)
        if n != len(s2):
            return False
        dp = [[[False] * (n+1) for _ in range(n)] for _ in range(n)]
        
        # initialize the matrix for the base case
        for i in range(n):
            for j in range(n):
                dp[i][j][1] = (s1[i] == s2[j])
        
        # fill the matrix for larger lengths
        for k in range(2, n+1):
            for i in range(n-k+1):
                for j in range(n-k+1):
                    for m in range(1, k):
                        if (dp[i][j][m] and dp[i+m][j+m][k-m]) or (dp[i][j+k-m][m] and dp[i+m][j][k-m]):
                            dp[i][j][k] = True
                            break
        return dp[0][0][n]