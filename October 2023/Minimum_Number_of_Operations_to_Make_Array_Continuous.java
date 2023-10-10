class Solution {
    public int minOperations(int[] nums) {
        int length = nums.length;
        int minOperations = length;
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        Integer[] sortedUniqueNums = uniqueNums.toArray(new Integer[uniqueNums.size()]);
        Arrays.sort(sortedUniqueNums);
        int right = 0;

        for (int left = 0; left < sortedUniqueNums.length; left++) {
            while (right < sortedUniqueNums.length && sortedUniqueNums[right] < sortedUniqueNums[left] + length) {
                right++;
            }

            minOperations = Math.min(minOperations, length - (right - left));
        }

        return minOperations;        
    }
}