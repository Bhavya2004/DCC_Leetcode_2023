//Another Approach:
//         First of all we have to plot all the points in the graph. Then take one point initially and compare the slope of it with another point.Then move to next point and compare and so on...The points lying on the same line will have equal slope.
// For e.g if you are taking 1 as initial point then compare slope of 1 with 2 and 1 with 3 if they are equal all the three points lie on the same line.
//Formula for slope is ()y2-y1/x2-x1)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    cnt.merge(Math.atan2(points[j][1] - points[i][1],
                    	points[j][0] - points[i][0]), 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(cnt.values()) + 1);
        }
        return result;
    }
}