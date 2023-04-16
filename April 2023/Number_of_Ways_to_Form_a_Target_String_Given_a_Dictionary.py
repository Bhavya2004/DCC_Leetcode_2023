class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        alphabet = 26
        mod = 1000000007
        m = len(target)
        k = len(words[0])
        cnt = [[0] * k for _ in range(alphabet)]
        for j in range(k):
            for word in words:
                cnt[ord(word[j]) - ord('a')][j] += 1
        dp = [[0] * (k + 1) for _ in range(m + 1)]
        dp[0][0] = 1
        for i in range(m + 1):
            for j in range(k):
                if i < m:
                    dp[i + 1][j + 1] += (cnt[ord(target[i]) - ord('a')][j]
                                         * dp[i][j])
                    dp[i + 1][j + 1] %= mod
                dp[i][j + 1] += dp[i][j]
                dp[i][j + 1] %= mod
        return dp[m][k]