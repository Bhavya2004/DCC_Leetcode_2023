class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        # Set the search space to [left, right], where left is the minimum possible time
        # and right is the maximum possible time (i.e., the time taken by the bus that
        # takes the longest time to complete one trip, multiplied by the total number of
        # trips that need to be completed).
        left = 0
        right = max(time) * totalTrips

        # Perform binary search to find the minimum time required to complete totalTrips
        while left < right:
            mid = (left + right) // 2
            # Compute the total number of trips that can be completed within mid time units
            num_trips = sum(mid // t for t in time)

        # If the total number of trips is less than totalTrips, search for a larger time
        # value in the right half of the search space. Otherwise, search for a smaller
        # time value in the left half of the search space.
            if num_trips < totalTrips:
                left = mid + 1
            else:
                right = mid

        # Return the minimum time required to complete totalTrips
        return left