# Question:
# For example, if the original list is [1, 2, 3, 5, 6, 8], the smallest sorted list of ranges would be ["1->3", "5->6", "8"]. This is because the numbers 1, 2, and 3 form a consecutive range, as well as the numbers 5 and 6, while the number 8 is a standalone range.
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        n = len(nums)
        if n == 0:
            return []

        ranges = []
        start = nums[0]
        end = nums[0]

        for i in range(1, n):
            # Check if the current number is consecutive with the previous number
            if nums[i] == end + 1:
                end = nums[i]
            else:
            # Add the range to the list
                if start == end:
                    ranges.append(str(start))
                else:
                    ranges.append(str(start) + "->" + str(end))
            # Start a new range with the current number
                start = nums[i]
                end = nums[i]

    # Add the last range to the list
        if start == end:
            ranges.append(str(start))
        else:
            ranges.append(str(start) + "->" + str(end))

        return ranges