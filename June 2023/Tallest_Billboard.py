class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        ans={}
        return self.dfs(rods,0,0,ans)

    def dfs(self,nums,i,diff,ans):
        if (i,diff) in ans:
            return ans[(i,diff)]

        if i>=len(nums):
            if diff:
                return float('-inf')

            return 0

        long=self.dfs(nums,i+1,diff+nums[i],ans)
        skip=self.dfs(nums,i+1,diff,ans)
        short=self.dfs(nums,i+1,abs(nums[i]-diff),ans)+min(diff,nums[i])
        ans[(i,diff)]=max(long,short,skip)
        return ans[(i,diff)]      
        