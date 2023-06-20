# Question:
# You are given a list of numbers called nums and another number called k. The task is to calculate the average of subarrays in nums with a special property.The special property is that each subarray should be centered around a particular index in nums and have a radius of k. The radius determines how many elements before and after the center index are included in the subarray.
class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        prefix_sum = [0] + list(accumulate(nums))  # Calculate the prefix sum of nums
        n = len(nums)
        averages = []

        for i in range(n):
            if k <= i < n - k:  # Check if there are enough elements before and after index i
                average = (prefix_sum[i + k + 1] - prefix_sum[i - k]) // (2 * k + 1)
            else:
                average = -1
            averages.append(average)

        return averages