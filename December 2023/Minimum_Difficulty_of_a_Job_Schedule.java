class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
    if (n < d) {
        return -1; 
    }

    int[][] dp = new int[d][n];
    dp[0][0] = jobDifficulty[0];

    for (int i = 1; i < n; i++) {
        dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
    }

    for (int i = 1; i < d; i++) {
        for (int j = i; j < n; j++) {
            int maxDifficulty = jobDifficulty[j];
            dp[i][j] = Integer.MAX_VALUE;

            for (int k = j; k >= i; k--) {
                maxDifficulty = Math.max(maxDifficulty, jobDifficulty[k]);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + maxDifficulty);
            }
        }
    }

    return dp[d - 1][n - 1];
    }
}