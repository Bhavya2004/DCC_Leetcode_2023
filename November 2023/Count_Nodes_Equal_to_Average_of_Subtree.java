class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        traverse(root, result);
        return result[0];
    }

    private int[] traverse(TreeNode node, int[] result) {
        if (node == null) return new int[]{0, 0};
        
        int[] left = traverse(node.left, result);
        int[] right = traverse(node.right, result);
        
        int currSum = node.val + left[0] + right[0];
        int currCount = 1 + left[1] + right[1];
        
        if (currSum / currCount == node.val) result[0]++;
        
        return new int[]{currSum, currCount};
    }
}