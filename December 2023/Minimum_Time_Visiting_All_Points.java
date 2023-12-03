class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int i = 1; i < points.length; i++) {
            int[] currentPoint = points[i];
            int[] previousPoint = points[i - 1];
            int dx = Math.abs(currentPoint[0] - previousPoint[0]);
            int dy = Math.abs(currentPoint[1] - previousPoint[1]);
            minTime += Math.max(dx, dy);
        }
        return minTime;
    }
}