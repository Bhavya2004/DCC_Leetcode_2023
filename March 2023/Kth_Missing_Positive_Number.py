#we will solve this using binary search
#first of all find the mid element from given array
#now we will find that till mid element how many elements are missing
#so to find that we will do:-  value of mid - index of mid -1
#now this value will decide whether to search in the left part of given array
# or the right part:
#  -> if k > missing than left=mid+1 else right =mid-1
# now we will repeat this process unit left<right and after that to find the
# kth missing number:- index of right +k + 1
class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        l,r=0,len(arr)-1
        while l<=r:
            m=(l+r)//2
            missing = arr[m] - m - 1

            if missing < k :
                l=m+1
            else:
                r=m-1
        
        return r + k + 1


            