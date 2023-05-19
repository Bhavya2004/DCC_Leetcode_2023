class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)  # Number of nodes in the graph
        components = [-1] * n  # An array to store the assigned component for each node
        is_valid = [True]  # A list to store the validity of the bipartite graph
        
        def dfs(node, component):
            components[node] = component  # Assign the current component to the current node
            
            for neighbor in graph[node]:  # Iterate over neighbors of the current node
                if components[neighbor] == -1:  # If the neighbor is unvisited
                    dfs(neighbor, 1 - component)  # Recursively call dfs on the neighbor with the opposite component
                elif components[neighbor] == component:  # If the neighbor is visited and has the same component
                    is_valid[0] = False  # The graph is not bipartite
                    return
        
        for i in range(n):  # Iterate over all nodes in the graph
            if components[i] == -1:  # If the current node is unvisited
                dfs(i, 0)  # Call dfs on the current node with component 0
        
        return is_valid[0]  # Return the validity of the bipartite graph