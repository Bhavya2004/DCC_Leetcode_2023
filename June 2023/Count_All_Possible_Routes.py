class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        @cache
        def ans(pos, remaining):
            res = 1 if pos == finish else 0
            for i in range(len(locations)):
                dist = abs(locations[i] - locations[pos])
                if i != pos and dist <= remaining:
                    res += ans(i, remaining - dist)
            return res % 1000000007
        return ans(start, fuel)