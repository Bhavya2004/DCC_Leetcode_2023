class Solution {
    public long minimumReplacement(int[] nums) {
        long[] operations = {0};
        int rightEdge = nums[nums.length -1];
        for (int i = nums.length -2; i >=0; i--) {
            rightEdge = replaceToMinimum(nums[i], rightEdge, operations);
        }
        return operations[0];
    }

    private int replaceToMinimum(int left, int right, long[] operations) {
        if (left <= right) {
            return left;
        }
        int div = left / right;
        if (left % right == 0) {
            operations[0] += (div - 1);
            return right;
        } else {
            operations[0] += div;
            return left / (div + 1);
        }
    }
}