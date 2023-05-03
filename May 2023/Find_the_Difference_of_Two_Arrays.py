class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        a = set(nums1)
        b = set(nums2)
        return [[i for i in a if i not in b], [i for i in b if i not in a]]
        