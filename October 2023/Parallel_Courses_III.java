class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        
        // Create a graph and calculate in-degrees
        for (int[] relation : relations) {
            int prevCourse = relation[0] - 1;
            int nextCourse = relation[1] - 1;
            if (graph[prevCourse] == null) {
                graph[prevCourse] = new ArrayList<>();
            }
            graph[prevCourse].add(nextCourse);
            inDegree[nextCourse]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] completionTime = new int[n];
        int maxTime = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (graph[course] != null) {
                for (int nextCourse : graph[course]) {
                    inDegree[nextCourse]--;
                    completionTime[nextCourse] = Math.max(completionTime[nextCourse], completionTime[course] + time[course]);
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
            maxTime = Math.max(maxTime, completionTime[course] + time[course]);
        }
        
        return maxTime;
    }
}
