class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        parent = [i for i in range(n)]
        sz = [1 for i in range(n)]

        def root(x):
            if x == parent[x]:
                return x
            parent[x] = root(parent[x])
            return parent[x]

        def join(x, y):
            x, y = root(x), root(y)
            if x == y:
                return
            if sz[x] > sz[y]:
                x, y = y, x
            parent[x] = y
            sz[y] += sz[x]
    
        events = []
        for i, j, k in edgeList:
            events.append((k, 10**18, i, j))
        q = len(queries)
        res = [0]*q
        for i in range(q):
            events.append((queries[i][2], i, queries[i][0], queries[i][1]))
        for a, b, c, d in sorted(events):
            if b == 10**18:
                #print('join', c, d)
                join(c, d)
            else:
                #print('query', c, d)
                res[b] = root(c) == root(d)
        return res
            