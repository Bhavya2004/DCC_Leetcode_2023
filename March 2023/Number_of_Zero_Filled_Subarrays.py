# loop through all the elements of nums.
# if 0 is encounterd,increment count variable and after that add count to a total variable
# if non zero is encountered,set the count to 0 and loop through remaining elements
# after all the elements apperead,return the total variable.
# time:-O(n) space:-O(1)
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        curr=total=0
        for i in nums:
            if i==0:
                curr+=1
                total+=curr
            else:
                curr=0
        return total