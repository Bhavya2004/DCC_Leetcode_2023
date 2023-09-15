class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        
        // Calculate all possible edges and their costs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, cost));
            }
        }
        
        // Sort edges by cost in ascending order
        Collections.sort(edges, (a, b) -> Integer.compare(a.cost, b.cost));
        
        int minCost = 0;
        UnionFind uf = new UnionFind(n);
        
        // Kruskal's algorithm to find minimum spanning tree
        for (Edge edge : edges) {
            if (uf.union(edge.from, edge.to)) {
                minCost += edge.cost;
            }
        }
        
        return minCost;
    }
}

class Edge {
    int from;
    int to;
    int cost;
    
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class UnionFind {
    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false; // x and y are already in the same group
        }
        parent[rootX] = rootY;
        return true;
    }
}
