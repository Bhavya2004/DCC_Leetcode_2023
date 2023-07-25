class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        low, high = 1, len(arr)
        while low != high:
            mid = (low+high+1) >> 1
            if arr[mid] > arr[mid-1]:
                low = mid
            else:
                high = mid-1
        return low