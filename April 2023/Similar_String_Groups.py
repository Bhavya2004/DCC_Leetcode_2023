class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        n = len(strs)
        edges = [[] for i in range(n)]
        seen = [False]*n
        for i in range(n):
            for j in range(i+1, n):
                l = []
                for k in range(len(strs[i])):
                    if strs[i][k] != strs[j][k]:
                        l.append(k)
                if len(l) == 0 or (len(l) == 2 and strs[i][l[0]] == strs[j][l[1]] and strs[i][l[1]] == strs[j][l[0]]):
                    edges[i].append(j)
                    edges[j].append(i)

        def dfs(x):
            seen[x] = True
            for i in edges[x]:
                if not seen[i]:
                    dfs(i)
                
        ans = 0
        for i in range(n):
            if not seen[i]:
                dfs(i)
                ans += 1

        return ans