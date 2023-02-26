//Basically the concept i have used is LCS(Longest common subsequence) using dp
// Let's define dp[i][j] as the minimum number of operations required to convert the prefix of word1 up to length i to the prefix of word2 up to length j
// If the last characters of word1 and word2 are the same, dp[i][j] = dp[i-1][j-1], since no operation is needed in this case.
// Otherwise, we can perform one of the following operations:
// Insert a character: dp[i][j] = dp[i][j-1] + 1
// Delete a character: dp[i][j] = dp[i-1][j] + 1
// Replace a character: dp[i][j] = dp[i-1][j-1] + 1
// We take the minimum of these three values as dp[i][j].
// Finally, the minimum number of operations required to convert word1 to word2 is stored in dp[m][n], where m is the length of word1 and n is the length of word2.
class Solution {
    public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m+1][n+1];
    for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
    }
    return dp[m][n];
    }
}