# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        res = [0]
        def dfs(root, lp, rp):
            if not root:
                return
            res[0] = max(res[0], lp, rp)
            dfs(root.left, rp+1, 0)
            dfs(root.right, 0, lp+1)
        dfs(root, 0, 0)
        return res[0]