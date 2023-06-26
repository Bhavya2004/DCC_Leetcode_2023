class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        ans = 0
        l = 0
        r = len(costs) - 1
        h1 = [inf]
        h2 = [inf]

        for _ in range(k):
            [heappush(h1, costs[(l:=l+1)-1]) for _ in range(min(r-l+1,candidates-len(h1)+1))]
            [heappush(h2, costs[(r:=r-1)+1]) for _ in range(min(r-l+1,candidates-len(h2)+1))]
            ans += heappop(h1 if h1[0]<=h2[0] else h2)

        return ans