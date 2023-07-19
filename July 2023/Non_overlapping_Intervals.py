class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        close = float('-inf')
        count = 0
        # Sort the intervals in asc order based on second value
        for i in sorted(intervals,key=lambda x:x[1]):
            if i[0] >= close:
                close = i[1]
            else:
                count += 1
        return count


