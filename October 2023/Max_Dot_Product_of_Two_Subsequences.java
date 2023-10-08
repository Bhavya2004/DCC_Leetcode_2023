class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] maxProducts = new int[nums1.length][nums2.length];
        findMaxProduct(maxProducts, nums1, nums2);
        return maxProducts[0][0];
    }

    private void findMaxProduct(int[][] maxProducts, int[] nums1, int[] nums2) {
        int colProduct, upperRightToCompare, rightSideToAdd, bottomRightToCompare;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                upperRightToCompare = i < nums1.length - 1 ? maxProducts[i+1][j] : Integer.MIN_VALUE;
                bottomRightToCompare = j < nums2.length - 1 ? maxProducts[i][j+1] : Integer.MIN_VALUE;
                rightSideToAdd = i < nums1.length - 1 && j < nums2.length - 1 ? maxProducts[i+1][j+1] : 0;
                colProduct = nums1[i] * nums2[j];
                upperRightToCompare = Math.max(upperRightToCompare, bottomRightToCompare);
                maxProducts[i][j] = Math.max(colProduct, Math.max(upperRightToCompare, colProduct + rightSideToAdd));
            }
        }
    }
}