class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        count = defaultdict(int)
        res = 0
        for i in arr:
            before = i - difference
            count[i] = max(count[i], count[before] + 1)
            res = max(res, count[i])
        return res