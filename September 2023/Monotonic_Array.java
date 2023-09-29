class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }
}