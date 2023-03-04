class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int leftBound = -1;
        int lastMin = -1, lastMax = -1;
        long count = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                lastMin = (nums[i] == minK) ? i : lastMin;
                lastMax = (nums[i] == maxK) ? i : lastMax;
                count += Math.max(0, Math.min(lastMin, lastMax) - leftBound);
            } else {
                leftBound = i;
                lastMin = -1;
                lastMax = -1;
            }
        }
        
        return count;
    }
}