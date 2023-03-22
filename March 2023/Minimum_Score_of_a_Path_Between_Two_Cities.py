#i have used BFS
#create dictionary:-city_number={connected_city:distance,connected_city2:distance,....}
#create a queue and insert 1st node then pop it and insert it in visited and insert adj nodes in the queue and write values of curr,adj,score.Take min value of distance and insert it in min variable
#curr represents current city,adj represents adjacent nodes connected,score represents distance between curr and adj,min represents minimum distance
class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        graph=defaultdict(dict)
        for u,v,w in roads:
            graph[v][u]=graph[u][v]=w

        minimum=float('inf')
        visited=set()
        visited.add(1)
        queue=deque([1])

        while queue:
            curr=queue.popleft()
            for adj,score in graph[curr].items():
                if adj not in visited:
                    visited.add(adj)
                    queue.append(adj)
                minimum=min(score,minimum)
        return minimum