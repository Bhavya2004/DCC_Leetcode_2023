#Approach
#->We build the graphgand initialize the setseento track which nodes have been visited.
#->We start atnode = 0, as directed, and traverse the graph recursively. We return when we hit a dead-end node, that is, a nodenfor which all nodes in g[n] already have been visited.
class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        seen, g = set(), defaultdict(list)

        for a,b in edges: 
            g[a].append((b))  ;  g[b].append((a))
           
        def dfs(node: int)->int:
            seen.add(node)    
  
            ans = sum(dfs(n) for n in g[node] if n not in seen) 
 
            if not ans and not hasApple[node]: return 0

            return ans+2           

        return max (0,dfs(0)-2)