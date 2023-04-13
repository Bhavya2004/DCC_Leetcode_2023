class Solution {
    // dsu
    int[] root;
    int[] cnt;
    int get(int x) {
        return x == root[x] ? x : (root[x] = get(root[x]));
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // each node is a good path
        int n = vals.length, ans = n;
        cnt = new int[n];
        root = new int[n];
        // each element is in its own group initially
        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt[i] = 1;
        }
        // sort by vals
        List<int[]> edgesList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) edgesList.add(edges[i]);
        Collections.sort(edgesList, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                int a = Math.max(vals[x[0]], vals[x[1]]);
                int b = Math.max(vals[y[0]], vals[y[1]]);
                if(a < b) return -1;
                else if(a > b) return 1;
                else return 0;
            }
        });

        // iterate each edge
        for (int[] e : edgesList) {
            int x = e[0], y = e[1];
            // get the root of x
            x = get(x);
            // get the root of y
            y = get(y);
            // if their vals are same, 
            if (vals[x] == vals[y]) {
                // then there would be cnt[x] * cnt[y] good paths
                ans += cnt[x] * cnt[y];
                // unite them
                root[x] = y;
                // add the count of x to that of y
                cnt[y] += cnt[x];
            } else if (vals[x] > vals[y]) {
                // unite them
                root[y] = x;
            } else {
                // unite them
                root[x] = y;
            }
        }
        return ans;
    }
}