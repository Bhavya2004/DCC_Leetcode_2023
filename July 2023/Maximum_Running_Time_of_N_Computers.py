class Solution:
    def maxRunTime(self, n, batteries):
        left=0
        right=sum(batteries)//n+1
        
        def check(time):
            return sum(min(time,b) for b in batteries)>=n*time

        while left<=right:
            mid=(left+right)//2
            if check(mid):
                left=mid+1

            else:
                right=mid-1

        return right                    