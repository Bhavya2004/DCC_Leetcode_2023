class Solution(object):
    def maxUncrossedLines(self, nums1, nums2):
        n,m=len(nums1),len(nums2)
        dp=[[-1]*m for i in range(n)]
        def f(i,j):
            if i==len(nums1) or j==len(nums2):
                return 0
            if dp[i][j]!=-1:
                return dp[i][j]
            if nums1[i]==nums2[j]:
                dp[i][j]=1+f(i+1,j+1)
            dp[i][j]=max(dp[i][j],f(i,j+1),f(i+1,j))
            return dp[i][j]
        return f(0,0)