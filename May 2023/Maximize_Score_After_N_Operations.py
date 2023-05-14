class Solution:
    def maxScore(self, nums: List[int]) -> int:
        n = len(nums)
        @cache
        def ans(b, r):
            if b == 0:
                return 0
            l = [i for i in range(n) if b&(1<<i)]
            res = 0
            for i in range(len(l)):
                for j in range(i+1, len(l)):
                    res = max(res, r * gcd(nums[l[i]], nums[l[j]]) + ans(b^(1<<l[i])^(1<<l[j]), r+1))
            return res
        return ans((1<<n)-1, 1)