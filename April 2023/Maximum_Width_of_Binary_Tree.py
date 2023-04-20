class Solution:
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        return self.helper(root, 0, 1, [])

    def helper(self, root: TreeNode, depth: int, index: int, lst: List[int]) -> int:
        if root is None:
            return 0
        if depth == len(lst):
            lst.append(index)
        currWidth = index - lst[depth] + 1
        leftWidth = self.helper(root.left, depth + 1, index * 2, lst)
        rightWidth = self.helper(root.right, depth + 1, index * 2 + 1, lst)
        return max(currWidth, max(leftWidth, rightWidth))