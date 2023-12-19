class Solution {
    public int[][] imageSmoother(int[][] image) {
        int rows = image.length;
    int cols = image[0].length;
    int[][] smoothedImage = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            int count = 0;

            for (int r = i - 1; r <= i + 1; r++) {
                for (int c = j - 1; c <= j + 1; c++) {
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        sum += image[r][c];
                        count++;
                    }
                }
            }

            smoothedImage[i][j] = sum / count;
        }
    }

    return smoothedImage;
    }
}