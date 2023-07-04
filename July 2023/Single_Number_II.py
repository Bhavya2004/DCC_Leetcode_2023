class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            count = 0
            for j in range(n):
                if nums[i] == nums[j]:
                    count += 1
            if count == 1:
                return nums[i]
        