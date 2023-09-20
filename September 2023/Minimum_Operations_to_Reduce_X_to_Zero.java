class Solution {
    public int minOperations(int[] nums, int x) {
        // find sum of input array
        int sum = 0;
        for(int num:nums) sum += num;

        // take maxLength as -1 and currSum as 0
        int maxLength = -1, currSum = 0;

        // loop over input array
        // left for reducing from currSum & right for adding to currSum
        for(int left=0,right=0; right<nums.length; right++){
            currSum += nums[right];
            // what if currSum exceeds sum-x(target) reduce left
            while(left <= right && currSum > sum-x){
                currSum -= nums[left++];
            }
            // what if currSum equals sum-x(target) update maxLength
            if(currSum == sum-x){
                maxLength = Math.max(maxLength,right-left+1);
            }   
        }
        // edge cases has to be handled here
        return maxLength == -1 ? -1 : nums.length-maxLength;
    }
}