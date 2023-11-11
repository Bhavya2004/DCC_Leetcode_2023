
import java.util.*;

class Graph {
    List<int[]>[] adjList;
    int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            adjList[from].add(new int[]{to, cost});
        }
    }

    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        adjList[from].add(new int[]{to, cost});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        pq.offer(new int[]{node1, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];
            if (node == node2) {
                return distance;
            }
            if (distance > dist[node]) {
                continue;
            }
            for (int[] neighbor : adjList[node]) {
                int nextNode = neighbor[0];
                int nextDistance = distance + neighbor[1];
                if (nextDistance < dist[nextNode]) {
                    dist[nextNode] = nextDistance;
                    pq.offer(new int[]{nextNode, nextDistance});
                }
            }
        }
        return -1;
    }
}
