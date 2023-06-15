# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        level_sums = Counter()

        def traverse(node, level):
            if node is not None:
                level_sums[level] += node.val
                traverse(node.left, level + 1)
                traverse(node.right, level + 1)

        traverse(root, 1)
        return max(level_sums, key=level_sums.get)