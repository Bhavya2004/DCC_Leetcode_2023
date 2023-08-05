# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        def generate_trees(start, end):
            if start > end:
                return [None]

            all_trees = []
            for root_val in range(start, end + 1):
                left_subtrees = generate_trees(start, root_val - 1)
                right_subtrees = generate_trees(root_val + 1, end)

                for left_tree in left_subtrees:
                    for right_tree in right_subtrees:
                        root = TreeNode(root_val)
                        root.left = left_tree
                        root.right = right_tree
                        all_trees.append(root)

            return all_trees

        if n == 0:
            return []
        
        return generate_trees(1, n)
