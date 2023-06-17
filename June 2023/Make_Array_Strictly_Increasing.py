# Goal -- Return minimum number of replacement req. from arr2 to arr1 to make arr1  strictly increasing.
class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        arr2.sort()  
        n = len(arr1)
        dp = {-1: 0}  # Dictionary to store minimum operations for each element encountered

        for i in range(n):
            temp = {}  # Temporary dictionary to store updated minimum operations for the current element

            for key in dp:
                # If the current element of arr1 is greater than the previous key in dp,
                # update the corresponding value with the minimum of its current value and the minimum operations for the previous key
                if arr1[i] > key:
                    temp[arr1[i]] = min(temp.get(arr1[i], sys.maxsize), dp[key])

                # Perform a binary search on arr2 to find the smallest element greater than the previous key in dp
                index = self.binary_search(arr2, key)
                if index < len(arr2):
                    # If such an element exists, update its corresponding value with the minimum of its current value
                    # and the minimum operations for the previous key plus one
                    temp[arr2[index]] = min(temp.get(arr2[index], sys.maxsize), dp[key] + 1)

            dp = temp  # Update dp with the updated minimum operations for the current element

        if dp:
            return min(dp.values())  # Return the minimum value from dp as the result
        else:
            return -1  # If dp is empty, return -1

    def binary_search(self, arr: List[int], target: int) -> int:
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = (left + right) // 2
            if arr[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1

        return left  # Return the left index after the binary search