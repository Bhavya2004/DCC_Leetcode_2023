class Solution(object):
    def eventualSafeNodes(self, graph):
        c = defaultdict(int)
        def dfs(x):
            if c[x]:
                return c[x] == 2
            c[x] = 1
            for v in graph[x]:
                if c[v] == 2:
                    continue
                if c[v] == 1 or not dfs(v):
                    return False
            c[x] = 2
            return True

        return [i for i in range(len(graph)) if dfs(i)]