# Palindrome : Reversing a string remains same as original 
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp = [0] * n

        for i in range(n-1,-1,-1):

            newdp = [0] * n
            newdp[i] = 1

            for j in range(i+1,n):

                if s[i] == s[j]:

                    newdp[j] = 2 + dp[j-1]

                else:

                    newdp[j] = max(dp[j],newdp[j-1])

            dp=newdp
        
        return dp[-1]