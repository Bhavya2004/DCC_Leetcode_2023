class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        Map<Integer, Set<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.putIfAbsent(stop, new HashSet<>());
                stopToBuses.get(stop).add(i);
            }
        }
        
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(source);
        visitedStops.add(source);
        
        int busesTaken = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                if (currentStop == target) return busesTaken;
                
                for (int bus : stopToBuses.get(currentStop)) {
                    if (visitedBuses.contains(bus)) continue;
                    
                    visitedBuses.add(bus);
                    
                    for (int stop : routes[bus]) {
                        if (!visitedStops.contains(stop)) {
                            visitedStops.add(stop);
                            queue.offer(stop);
                        }
                    }
                }
            }
            busesTaken++;
        }
        
        return -1;
    }
}
