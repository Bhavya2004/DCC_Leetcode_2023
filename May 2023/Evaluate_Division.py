class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        # Step 1: Create the graph
        graph = defaultdict(dict)
    
    # Step 2: Populate the graph with equations and values
        for (numerator, denominator), value in zip(equations, values):
            graph[numerator][denominator] = value
            graph[denominator][numerator] = 1 / value

    # Step 3: DFS function
        def dfs(curr_node, target_node, visited):
            if curr_node == target_node:
                return 1.0
        
            visited.add(curr_node)
            for neighbor, weight in graph[curr_node].items():
                if neighbor not in visited:
                    result = dfs(neighbor, target_node, visited)
                    if result != -1.0:
                        return weight * result
        
            return -1.0
    
    # Step 4: Process the queries
        results = []
        for query in queries:
            numerator, denominator = query
        
        # Check if variables exist in the graph
            if numerator not in graph or denominator not in graph:
                results.append(-1.0)
            else:
                results.append(dfs(numerator, denominator, set()))
    
    # Step 5: Return the results
        return results