class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];  // Dynamic programming array to store valid partition information
        dp[0] = true;  // Base case: Empty subarray is always valid

        if (nums[1] == nums[0]) dp[2] = true;  // Initialize dp[2] if the first two elements are equal
        for (int i = 2; i < n; i++) {
            // Check if the current element is equal to the previous element
            if (nums[i] == nums[i - 1]) dp[i + 1] |= dp[i - 1];
            
            // Check if the current element is equal to the previous two elements
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) dp[i + 1] |= dp[i - 2];
            
            // Check if the current element is three more than the previous two elements
            if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) dp[i + 1] |= dp[i - 2];
        }

        return dp[n];  // Return the value indicating whether the entire array can be validly partitioned
    }
}
