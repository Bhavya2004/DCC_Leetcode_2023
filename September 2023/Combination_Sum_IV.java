// Recursion Approach : Time Limit Exceeded

// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//          // Base case: if target is 0, we found a valid combination.
//         if (target == 0) {
//             return 1;
//         }
        
//         int count = 0;
        
//         for (int num : nums) {
//             // Check if num can be a part of the combination.
//             if (target >= num) {
//                 // Recursively find combinations with the remaining target.
//                 count += combinationSum4(nums, target - num);
//             }
//         }
        
//         return count;
//     }
// }

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // There is one way to reach a target of 0, which is not choosing any number.
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}