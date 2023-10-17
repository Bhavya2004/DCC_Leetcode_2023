class Solution {
    
    // Breadth-First Search to check if the given nodes form a valid binary tree
    private boolean isBinaryTreeValid(int root, int[] leftChild, int[] rightChild) {
        boolean[] visited = new boolean[leftChild.length]; // Tracks visited nodes
        Queue<Integer> nodeQueue = new LinkedList<>(); // Queue for BFS traversal
        nodeQueue.offer(root);
        visited[root] = true;

        while (!nodeQueue.isEmpty()) {
            int current = nodeQueue.poll();

            // Check left child
            if (leftChild[current] != -1) {
                if (visited[leftChild[current]]) // Check for cycle
                    return false;

                nodeQueue.offer(leftChild[current]);
                visited[leftChild[current]] = true; // Mark left child as visited
            }

            // Check right child
            if (rightChild[current] != -1) {
                if (visited[rightChild[current]]) // Check for cycle
                    return false;

                nodeQueue.offer(rightChild[current]);
                visited[rightChild[current]] = true; // Mark right child as visited
            }
        }

        // Check if there are multiple components
        for (boolean visit : visited) {
            if (!visit)
                return false;
        }

        return true; // All nodes form a valid binary tree
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] childCount = new boolean[n]; // Tracks child count for each node

        // Update child count based on leftChild
        for (int child : leftChild) {
            // Check if node has child
            if (child != -1)
                childCount[child] = true; // Mark left child as having a parent
        }

        // Update child count based on rightChild
        for (int child : rightChild) {
            // Check if node has child
            if (child != -1) {
                if (childCount[child]) // Check if the right child already has a parent
                    return false;

                childCount[child] = true; // Mark right child as having a parent
            }
        }

        int root = -1; // Root node
        for (int i = 0; i < n; ++i) {
            if (!childCount[i]) {
                if (root == -1)
                    root = i; // Set root node if not assigned
                else
                    return false; // Multiple roots found, not a valid binary tree
            }
        }

        if (root == -1)
            return false; // No root found, not a valid binary tree

        return isBinaryTreeValid(root, leftChild, rightChild); // Check if the tree is valid
    }

}