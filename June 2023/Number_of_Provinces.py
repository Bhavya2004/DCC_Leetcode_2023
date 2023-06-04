class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n=len(isConnected)
        provinces=0
        visited=[False]*n

        def dfs(node):
            visited[node]=True
            for neighbor in range(n):
                if isConnected[node][neighbor] == 1 and not visited[neighbor]:
                    dfs(neighbor)

        for i in range(n):
            if not visited[i]:
                dfs(i)
                provinces += 1

        return provinces