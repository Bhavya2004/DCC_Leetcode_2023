class Solution {
// This method takes the root of a binary tree as input and returns a list of root nodes of all duplicate subtrees. We create an empty result list to hold the root nodes of the duplicate subtrees, and a map to keep track of the frequency of each subtree in the tree. We then call the postorderTraversal method to traverse the tree and find the duplicate subtrees.
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    postorderTraversal(root, map, result);
    return result;
    }

// This method performs a postorder traversal of the binary tree rooted at node. We recursively visit each node in the tree and construct the string representation of the subtree rooted at that node. The string representation of the subtree consists of the value of the node concatenated with the string representations of its left and right subtrees, separated by commas. We also keep track of the frequency of each subtree in the map.
    private String postorderTraversal(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
// If the node is null, we return the string "#". This serves as a marker for null nodes in the string representation of the subtree.
    if (node == null) {
        return " ";
    }
// We then recursively traverse the left and right subtrees of node using the postorderTraversal method, passing in the map and result as arguments. The left and right strings are the string representations of the left and right subtrees of node, respectively.
    String left = postorderTraversal(node.left, map, result);
    String right = postorderTraversal(node.right, map, result);

// We then concatenate the value of node with the left and right strings, separated by commas, to form the string representation of the subtree rooted at node. We store this string representation in the subtree variable.
    String subtree = node.val + "," + left + "," + right;

// We then check if the subtree has occurred before by looking it up in the map. If the subtree has occurred before (i.e., its count in the map is 1), we add the node to the result list. This is because we only need to add one instance of each duplicate subtree to the result list.
    int count = map.getOrDefault(subtree, 0);
    if (count == 1) {
        result.add(node);
    }
// Finally, we increment the frequency of the subtree in the map by putting it in the map with a count one greater than its current count. We then return the subtree string.
    map.put(subtree, count + 1);
    return subtree;
}
}