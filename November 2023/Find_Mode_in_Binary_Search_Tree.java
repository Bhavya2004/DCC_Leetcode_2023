/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


 public class Solution {
    private int maxCount;
    private int currentCount;
    private int prevValue;
    private List<Integer> modes;

    public int[] findMode(TreeNode root) {
        maxCount = 0;
        currentCount = 0;
        prevValue = 0;
        modes = new ArrayList<>();

        inOrderTraversal(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        // Process the current node's value
        if (prevValue != node.val) {
            currentCount = 1;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        prevValue = node.val;

        inOrderTraversal(node.right);
    }
}
