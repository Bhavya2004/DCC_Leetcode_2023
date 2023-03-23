class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n - 1:
            return -1
        
        # Create a list of sets to represent the connected computers
        networks = [set([i]) for i in range(n)]

        # Merge connected computers into one set
        for a, b in connections:
            networks[a].add(b)
            networks[b].add(a)
        
        # Find the number of disjoint networks
        disjoint_networks = 0
        visited = [False] * n
        
        for i in range(n):
            if not visited[i]:
                self.dfs(networks, i, visited)
                disjoint_networks += 1
        
        # Return the minimum number of cable extractions required
        return disjoint_networks - 1
    
    def dfs(self, networks, i, visited):
        visited[i] = True
        for j in networks[i]:
            if not visited[j]:
                self.dfs(networks, j, visited)