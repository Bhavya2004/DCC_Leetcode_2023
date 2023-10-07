class Solution {
    public int numOfArrays(int n, int m, int k) {    
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        int MOD = (int) 1e9 + 7;
        
        for (int num = 0; num < dp[0].length; num++) {
            dp[n][num][0] = 1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int maxSoFar = m; maxSoFar >= 0; maxSoFar--) {
                for (int remain = 0; remain <= k; remain++) {
                    int ans = 0;
                    for (int num = 1; num <= maxSoFar; num++) {
                        ans = (ans + dp[i + 1][maxSoFar][remain]) % MOD;
                    }
                    
                    if (remain > 0) {
                        for (int num = maxSoFar + 1; num <= m; num++) {
                            ans = (ans + dp[i + 1][num][remain - 1]) % MOD;
                        }
                    }
                    
                    dp[i][maxSoFar][remain] = ans;
                }
            }
        }

        return dp[0][0][k];
    }
}