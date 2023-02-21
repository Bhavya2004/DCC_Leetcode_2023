# As the sol must be in o(logn) ,I have used binary search  
class Solution:
    
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2
        
            #element found
            if nums[mid] != nums[mid-1] and nums[mid] != nums[mid+1]:
                return nums[mid]
            #if mid is at even indice
            if mid % 2 == 0:
                if nums[mid] == nums[mid+1]:
                    left = mid + 1
                else:
                    right = mid - 1
            #mid at odd indice
            else:
                if nums[mid] == nums[mid-1]:
                    left = mid + 1
                else:
                    right = mid - 1
                
        return nums[left]