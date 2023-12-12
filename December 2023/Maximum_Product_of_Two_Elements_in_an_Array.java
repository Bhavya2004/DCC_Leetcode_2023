class Solution {
    public int maxProduct(int[] nums) {
         int maxProduct = 0;
    
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            int product = (nums[i] - 1) * (nums[j] - 1);
            maxProduct = Math.max(maxProduct, product);
        }
    }
    
    return maxProduct;
    }
}