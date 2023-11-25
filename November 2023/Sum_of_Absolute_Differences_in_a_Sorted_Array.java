class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
    int[] result = new int[n];
    
    // Calculate the prefix sum of nums
    int[] prefixSum = new int[n];
    prefixSum[0] = nums[0];
    for (int i = 1; i < n; i++) {
        prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    
    // Calculate the suffix sum of nums
    int[] suffixSum = new int[n];
    suffixSum[n-1] = nums[n-1];
    for (int i = n-2; i >= 0; i--) {
        suffixSum[i] = suffixSum[i+1] + nums[i];
    }
    
    // Calculate the result array
    for (int i = 0; i < n; i++) {
        int leftSum = i * nums[i] - (i > 0 ? prefixSum[i-1] : 0);
        int rightSum = (i < n-1 ? suffixSum[i+1] : 0) - (n-i-1) * nums[i];
        result[i] = leftSum + rightSum;
    }
    
    return result;
    }
}