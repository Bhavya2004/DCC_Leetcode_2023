# We create two variables dp and ans. dp is a list initialized to a very large value (10**10) for each index up to n+1. ans is an empty list.

# Now we iterate over each element elem in the obstacles array. For each element, we find the index ind where it should be inserted into the dp list using the bisect.bisect() function from the bisect module. This function finds the index at which the element should be inserted in the sorted list.

# Next, we append ind+1 to the ans list. This is because ind is the index at which the current elem should be inserted in the sorted dp list, and the length of the longest obstacle course up to this position is ind+1.

# Finally, we update the dp list by setting dp[ind] to elem. This is because we are trying to build a sorted list of obstacles where each obstacle is taller than or the same height as the obstacle immediately before it.

# Once we have iterated over all the elements in the obstacles array, we return the ans list.

class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        dp, ans = [10**10] * (len(obstacles) + 1), []
        for elem in obstacles:
            ind = bisect.bisect(dp, elem)
            ans += [ind + 1]
            dp[ind] = elem  
        return ans