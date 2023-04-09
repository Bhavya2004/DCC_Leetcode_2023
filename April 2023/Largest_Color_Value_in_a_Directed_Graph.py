class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        
            # Create adjacency list
        adj = [[] for _ in range(len(colors))]
        for s, e in edges:
            adj[s].append(e)

        # Initialize result variable and cache array
        res = 0
        cache = [None for _ in range(len(colors))]

        # Define DFS function to traverse the graph
        def dfs(current, visited):
            # If we have already visited this node in the current path, we are in a cycle
            if current in visited:
                return None
            # If we have already computed the result for this node, return it from the cache
            if cache[current] is not None:
                return cache[current]
            # Mark the current node as visited
            visited.add(current)

            # Initialize a dictionary to store the maximum count of each color seen so far
            res = {}
            # Traverse all the neighbors of the current node
            for con in adj[current]:
                # Recursively call the DFS function on the neighbor
                child_res = dfs(con, visited)
                # If we encounter a cycle, return None
                if child_res is None:
                    return None
                # Update the maximum count of each color seen so far
                for color, value in child_res.items():
                    res[color] = max(res.get(color, 0), value)

            # Remove the current node from the visited set
            visited.remove(current)

            # Update the count of the current node's color in the result dictionary
            currentColor = colors[current]
            res[currentColor] = res.get(currentColor, 0) + 1

            # Store the result in the cache and return it
            cache[current] = res
            return res

        # Traverse the graph using DFS and update the result variable
        response = 0
        for i in range(len(colors)):
            temp = dfs(i, set())
            # If we encounter a cycle, return -1
            if temp == None:
                return -1
            # Update the result variable with the maximum count of any color seen so far
            response = max(response, max(temp.values()))

        # Return the final result
        return response