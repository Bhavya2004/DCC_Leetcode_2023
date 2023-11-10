class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int u = pair[0], v = pair[1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int n = adjacentPairs.length + 1;
        int[] ans = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[0] = entry.getKey();
                break;
            }
        }
        ans[1] = adj.get(ans[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adjList = adj.get(ans[i - 1]);
            ans[i] = adjList.get(0) == ans[i - 2] ? adjList.get(1) : adjList.get(0);
        }
        return ans;
    }
}
