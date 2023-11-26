class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
    int n = matrix[0].length;
    
    int[][] dp = new int[m][n];
    
    // Calculate dp matrix
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 1) {
                dp[i][j] = (i > 0) ? dp[i-1][j] + 1 : 1;
            } else {
                dp[i][j] = 0;
            }
        }
    }
    
    int maxArea = 0;
    
    // Calculate maximum area
    for (int i = 0; i < m; i++) {
        Arrays.sort(dp[i]);
        for (int j = 0; j < n; j++) {
            int area = dp[i][j] * (n - j);
            maxArea = Math.max(maxArea, area);
        }
    }
    
    return maxArea;
    }
}