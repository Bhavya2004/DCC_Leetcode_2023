class Solution:
    def findNumberOfLIS(self, nums):
        dp=[1]*len(nums)
        print(dp)
        count = [1]*len(nums)
        for i in range(1,len(nums)):
            for j in range(i):
                if nums[j]<nums[i]:
                    if dp[i]<dp[j]+1:
                        dp[i]=dp[j]+1
                        count[i]=count[j]
                    elif dp[i]==dp[j]+1:
                        count[i]+=count[j]
                
        maxx=max(dp)
        ans=0
        
        print(dp)
        print(count)
                
        for i in range(len(dp)):
            if dp[i]==maxx:
                ans+=count[i]
        return ans