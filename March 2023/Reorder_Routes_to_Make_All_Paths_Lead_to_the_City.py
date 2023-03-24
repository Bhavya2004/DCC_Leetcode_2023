# we need to return min edges changed
#create a dictionary of adjacent nodes e.g 0:[1,4]
# take 3 variables res which is our final result,parent=-1(as there is no parent of 0) which is the parent node of current node and node=0(initially 0) which is the current node
# apply dfs

class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        self.res=0
        roads=set()
        graph=defaultdict(list)
        for u,v in connections:
            graph[v].append(u)
            graph[u].append(v)
            roads.add((u,v))

        def dfs(curr,parent):
            self.res+=(parent,curr) in roads
            for v in graph[curr]:
                if parent==v:continue
                dfs(v,curr)
        dfs(0,-1)
        return self.res
        