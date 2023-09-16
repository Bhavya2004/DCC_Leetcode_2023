class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int l = 0;
        int rt = 1000000;
        int res = 0;
        
        while (l <= rt) {
            int m = l + (rt - l) / 2;
            
            boolean[][] v = new boolean[r][c];
            
            if (search(heights, 0, 0, v, m, r, c)) {
                res = m;
                rt = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return res;
    }
    
    private boolean search(int[][] h, int row, int col, boolean[][] v, int m, int r, int c) {
        if (row == r - 1 && col == c - 1) {
            return true;
        }
        
        v[row][col] = true;
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            
            if (nr >= 0 && nr < r && nc >= 0 && nc < c && !v[nr][nc]) {
                int d = Math.abs(h[row][col] - h[nr][nc]);
                if (d <= m && search(h, nr, nc, v, m, r, c)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
