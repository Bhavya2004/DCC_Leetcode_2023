class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = 0;
        int maxRight = 0;

        for (int l : left) {
            maxLeft = Math.max(maxLeft, l);
        }

        for (int r : right) {
            maxRight = Math.max(maxRight, n - r);
        }

        return Math.max(maxLeft, maxRight);
    }
}
