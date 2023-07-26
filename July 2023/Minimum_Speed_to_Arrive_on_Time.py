class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        if len(dist) > ceil(hour):
            return -1
        low, high = 1, 10 ** 9
        while low != high:
            mid = (low+high) >> 1
            if sum((i+mid-1)//mid for i in dist[:-1]) + dist[-1] / mid <= hour:
                high = mid
            else:
                low = mid+1
        return low