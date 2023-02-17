# 1.Initialize a variable prev to null and a variable minDiff to infinity.
# 2.Traverse the tree in-order.
# 3.At each node:
# a. If prev is not null, update minDiff to be the minimum of minDiff and the absolute difference between the current node's value and the previous node's value.
# b. Set prev to the current node.
# 4.Return minDiff.
class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        self.prev = None
        self.minDiff = float('inf')
        self.inOrderTraversal(root)
        return self.minDiff
        
    def inOrderTraversal(self, node):
        if node is None:
            return
        self.inOrderTraversal(node.left)
        if self.prev is not None:
            self.minDiff = min(self.minDiff, abs(node.val - self.prev.val))
        self.prev = node
        self.inOrderTraversal(node.right)
