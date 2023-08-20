class Solution {
    private List<Integer>[] groupItems; // Stores items belonging to each group.
    private List<Integer>[] itemGraph; // Stores the graph of item dependencies.
    private int[] itemIndegrees; // Stores the indegree of each item.
    private int[] groupIndegrees; //// Stores the indegree of each group.
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        buildGroupItems(n, group);
        buildItemGraph(n, beforeItems, group);
        
        int[] result = new int[n];
        int index = 0;
        Queue<Integer> groupQueue = new LinkedList<>();
        
        // Initialize the queue with groups that have no incoming dependencies.
        for (int i = 0; i < n; i++) {
            if (groupIndegrees[i] == 0) {
                groupQueue.offer(i);
            }
        }
        
        while (!groupQueue.isEmpty()) {
            Integer groupId = groupQueue.poll();
            List<Integer> itemsInGroup = groupItems[groupId];
            
            if (itemsInGroup != null) {
                Queue<Integer> itemQueue = new LinkedList<>();
                
                // Initialize the queue with items that have no incoming dependencies within the group.
                for (var item : itemsInGroup) {
                    if (itemIndegrees[item] == 0) {
                        itemQueue.offer(item);
                    }
                }
                
                while (!itemQueue.isEmpty()) {
                    Integer item = itemQueue.poll();
                    result[index++] = item;
                    
                    if (itemGraph[item] != null) {
                        for (var neighbor : itemGraph[item]) {
                            itemIndegrees[neighbor]--;
                            
                            if (group[neighbor] != groupId) {
                                if (--groupIndegrees[group[neighbor]] == 0) {
                                    groupQueue.offer(group[neighbor]);
                                }
                            } else if (itemIndegrees[neighbor] == 0) {
                                itemQueue.offer(neighbor);
                            }
                        }
                    }
                }
            }
        }
        // If all items have been placed in the result array, return the result; otherwise, return an empty array.
        return index == n ? result : new int[0];
    }
    
    private void buildGroupItems(int n, int[] group) {
        groupItems = new List[n];
        int index = n - 1;

        // Organize items into groups and store them in the groupItems array.
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = index--;
            }
            
            if (groupItems[group[i]] == null) {
                groupItems[group[i]] = new ArrayList<>();
            }
            
            groupItems[group[i]].add(i);
        }
    }
    
    private void buildItemGraph(int n, List<List<Integer>> beforeItems, int[] group) {
        itemGraph = new List[n];
        itemIndegrees = new int[n];
        groupIndegrees = new int[n];
        
        // Build the item dependency graph and calculate indegrees for both items and groups.
        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (itemGraph[j] == null) {
                    itemGraph[j] = new ArrayList<>();
                }
                
                itemGraph[j].add(i);
                itemIndegrees[i]++;
                
                if (group[i] != group[j]) {
                    groupIndegrees[group[i]]++;
                }
            }
        }
    }
}