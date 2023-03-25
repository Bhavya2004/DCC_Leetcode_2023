class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        groups = defaultdict(int)
        seen = set()
        def dfs(i, grp):
            groups[grp] += 1
            for v in adj[i]:
                if v not in seen:
                    seen.add(v)
                    dfs(v, grp)
        
        grp = 0
        for i in range(n):
            if i not in seen:
                seen.add(i)
                dfs(i, grp)
                grp += 1
        
        res = 0
        total = n
        for k, v in groups.items():
            total -= v
            res += v * total
        
        return res
            