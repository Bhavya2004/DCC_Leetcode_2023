class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] even = new int[nums.length];
        int[] odd = new int[nums.length];
        int evenCount = 0;
        int oddCount = 0;
        
        // Separate even and odd numbers into their respective arrays
        for (int num : nums) {
            if (num % 2 == 0) {
                even[evenCount++] = num;
            } else {
                odd[oddCount++] = num;
            }
        }
        
        // Combine the even and odd arrays to create the result
        for (int i = 0; i < evenCount; i++) {
            nums[i] = even[i];
        }
        for (int i = 0; i < oddCount; i++) {
            nums[evenCount + i] = odd[i];
        }
        
        return nums;
    }
}
