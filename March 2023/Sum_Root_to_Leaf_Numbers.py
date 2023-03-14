# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, path):
            if not node:
                return 0
 # the path variable is used to keep track of the current path from the root to the current node, and to compute the root-to-leaf numbers that start from the current node
            path = 10 * path + node.val
            if not node.left and not node.right:
                return path
            return dfs(node.left, path) + dfs(node.right, path)

        return dfs(root, 0)
