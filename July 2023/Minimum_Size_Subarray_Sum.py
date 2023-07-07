class Solution:
    def minSubArrayLen(self, t: int, nums: List[int]) -> int:
        a=inf
        s=0
        l=0
        for i in range(len(nums)):
            s+=nums[i]
            while(s>=t):
                a=min(a,i+1-l)
                s-=nums[l]
                l+=1
        return a if a!=inf else 0