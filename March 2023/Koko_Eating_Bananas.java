// Brute-Force Approach(Time-Limit-Exceded)
// The algorithm first finds the maximum number of bananas in any pile. It then checks all possible eating speeds from 1 to the maximum pile size. For each speed, it calculates the number of hours required to eat all the bananas by dividing the number of bananas in each pile by the eating speed and rounding up to account for partial hours. If the total hours required is less than or equal to h, the function returns the current eating speed as the answer.

//So we will use Binary search:
class Solution {
    public int minEatingSpeed(int[] piles, int h) { 
  // Find the maximum number of bananas in any pile
    int maxPile = 0;
    for (int pile : piles) {
        maxPile = Math.max(maxPile, pile);
    }

    // Set the search space to be the range of possible eating speeds
    int left = 1; // Minimum eating speed
    int right = maxPile; // Maximum eating speed (eating all bananas in the largest pile in 1 hour)

    // Binary search for the smallest eating speed that allows Koko to eat all the bananas in h hours
    while (left < right) {
        int mid = left + (right - left) / 2; // Calculate the midpoint of the search space
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + mid - 1) / mid; // Calculate the total hours required to eat this pile at speed mid
        }
        if (hours <= h) {
            right = mid; // If it's possible to eat all the bananas within h hours, try a smaller speed
        } else {
            left = mid + 1; // If it's not possible to eat all the bananas within h hours, try a larger speed
        }
    }

    // Return the smallest eating speed that allows Koko to eat all the bananas in h hours
    return left;
}
     }
