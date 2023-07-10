# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None: 
            return 0
        def find_depth(node,l):
            if node.left is not None and node.right is not None:
                return min(find_depth(node.right, l+1),find_depth(node.left, l+1))
            
            if node.right is not None:
                return find_depth(node.right, l+1)
            if node.left is not None:
                return find_depth(node.left, l+1)
            return l
        return find_depth(root,1)
