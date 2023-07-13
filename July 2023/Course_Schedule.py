class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = defaultdict(list)
        seen = [0] * numCourses
        valid = [True]
        
        for cur, pre in prerequisites:
            adj[pre].append(cur)
        
        def dfs(i):
            seen[i] = 1
            for node in adj[i]:
                if seen[node] == 1:
                    valid[0] = False
                    return
                elif seen[node] == 0:
                    seen[node] = 1
                    dfs(node)
            seen[i] = 2
        
        for i in range(numCourses):
            if not valid:
                return False
            if not seen[i]:
                dfs(i)
        
        return valid[0]
        
        