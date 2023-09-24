class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][101]; // Create a 2D array to represent glasses

        // Pour the initial amount of champagne into the top glass
        glasses[0][0] = (double) poured;

        // Iterate through each row
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                // Calculate the overflow to the left and right glasses
                double overflow = (glasses[i][j] - 1.0) / 2.0;
                if (overflow > 0) {
                    glasses[i + 1][j] += overflow;
                    glasses[i + 1][j + 1] += overflow;
                }
            }
        }

        // Ensure the value is within the valid range [0, 1]
        return Math.min(1.0, glasses[query_row][query_glass]);
    }
}
