# first of all make a set of all distinct nodes
# then make a set of of all the destination nodes i.e from [0,1] , 1 is the destination node
# at last take the difference of both the set i.e all_nodes - destination_nodes
class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        all_nodes = set(range(n))

        destination = set(d for _, d in edges)

        ans = all_nodes - destination

        return ans