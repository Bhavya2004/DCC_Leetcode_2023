class Solution {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int min = nums[k], answer = nums[k];
        while (left > 0 || right < nums.length -1) {
            if ((left > 0 ? nums[left -1] : 0) < (right < nums.length -1 ? nums[right + 1] : 0)) {
                right++;
                min = Math.min(min, nums[right]);
            } else {
                left--;
                min = Math.min(min, nums[left]);
            }
            answer = Math.max(answer, min * (1 + right - left));
        }
        return answer;
    }
}