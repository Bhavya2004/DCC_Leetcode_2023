import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int left = 0, right = 0, idx = 0;
        
        Deque<Integer> deque = new LinkedList<>();
        
        while (right < n) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            
            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            
            // Add the current element's index to the deque
            deque.offerLast(right);
            
            // Check if the current window is of size k
            if (right - left + 1 == k) {
                result[idx++] = nums[deque.peekFirst()];
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}
