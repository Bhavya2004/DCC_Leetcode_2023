class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0, third = nums.length / 3, prevNum = Integer.MIN_VALUE, prevAdded = Integer.MIN_VALUE;
        for (int num : nums) {
            count = num == prevNum ? count + 1 : 1;
            if (count > third && num != prevAdded) {
                majorityElements.add(num);
                prevAdded = num;
            }
            prevNum = num;
        }
        return majorityElements;
    }
}