class Solution {
   public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right)); //return the maximum depth of the subtrees plus 1 (root node)
    }
}