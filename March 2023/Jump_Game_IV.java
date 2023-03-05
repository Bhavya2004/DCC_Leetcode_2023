class Solution {
    public int minJumps(int[] arr) {
    //    We first get the length of the input array arr.
    int n=arr.length;
    // If the length of arr is 1, we return 0 as we are already at the last index.
    if (n == 1) {
            return 0; 
        }
    // create map to store the indices of all elements in arr.
    Map<Integer, List<Integer>> map = new HashMap<>();
    // We loop through the elements of arr and add their indices to map.
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    // We create a Queue<Integer> called q to store the indices to be visited.
     Queue<Integer> q = new LinkedList<>();
    // create a boolean array to keep track of the indices that have been visited.
     boolean[] visited = new boolean[n];
    //  We add the starting index, which is 0, to q and mark it as visited in visited.
        q.offer(0); // Starting index
        visited[0] = true;
    // We initialize the steps variable to 0.
        int steps = 0;

        while (!q.isEmpty()) {
            //  get the size of q and loop through the indices in q
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // remove the first index in q and store it in curr.
                int curr = q.poll();
                if (curr == n - 1) { //we have reached the last index
                    return steps;
                }
                //  get the list of indices in map that have the same value as arr[curr] and                add curr - 1 and curr + 1 to the list.
                List<Integer> indices = map.get(arr[curr]);
                indices.add(curr - 1);
                indices.add(curr + 1);
// loop through the indices in the list and check if they are valid indices and have not been visited before. If so, we mark them as visited and add them to q.
                for (int index : indices) {
                    if (index >= 0 && index < n && !visited[index]) {
                        visited[index] = true;
                        q.offer(index);
                    }
                }
                indices.clear(); // Clear the list for the next iteration
            }
            steps++;
        } 
        // If we have not yet reached the last index, we continue with the next iteration of the loop and if  we have gone through all the indices not reached the last index, it means that it is not possible to reach the last index and we return -1.
        
        return -1;
    }
}