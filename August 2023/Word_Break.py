class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # TLE with recursive call
        # def segment(start):
        #     if start == len(s):
        #         return True

        #     for end in range(start + 1, len(s) + 1):
        #         if s[start:end] in wordDict and segment(end): #recursive call
        #             return True

        #     return False

        # return segment(0)
        dp = [False]*(len(s)+1)
        dp[0] = True

        for i in range(len(s) + 1):
            for j in range(i):
                if dp[j] == True and s[j:i] in wordDict:
                    dp[i] = True

        print(dp)
        return dp[-1]