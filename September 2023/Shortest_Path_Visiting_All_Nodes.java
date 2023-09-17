class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int targetMask = (1 << n) - 1; // Target mask to check if all nodes have been visited
        int[][] dp = new int[n][1 << n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            queue.offer(new int[]{i, 1 << i});
        }

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int currentNode = pair[0];
            int currentMask = pair[1];

            if (currentMask == targetMask) {
                return dp[currentNode][currentMask];
            }

            for (int neighbor : graph[currentNode]) {
                int nextMask = currentMask | (1 << neighbor);
                if (dp[neighbor][nextMask] > dp[currentNode][currentMask] + 1) {
                    dp[neighbor][nextMask] = dp[currentNode][currentMask] + 1;
                    queue.offer(new int[]{neighbor, nextMask});
                }
            }
        }

        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, dp[i][targetMask]);
        }

        return minPath;
    }
}
