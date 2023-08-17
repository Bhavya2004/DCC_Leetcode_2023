class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = matrix;
        int INF = 10000;

        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (matrix[i][j] == 1) dp[i][j] = INF;


        for (int i = 1; i < n; i++) dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + 1);
        for (int i = 1; i < m; i++) dp[0][i] = Math.min(dp[0][i], dp[0][i - 1] + 1);

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);


        for (int i = n - 2; i >= 0; i--) dp[i][m - 1] = Math.min(dp[i + 1][m - 1] + 1, dp[i][m - 1]);
        for (int i = m - 2; i >= 0; i--) dp[n - 1][i] = Math.min(dp[n - 1][i + 1] + 1, dp[n - 1][i]);

        for (int i = n - 2; i >= 0; i--)
            for (int j = m - 2; j >= 0; j--)
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]) + 1);

        return dp;
    }
}