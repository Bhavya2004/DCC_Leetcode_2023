# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        # Define the lambda function for in-order traversal and retrieving node values
        f = lambda n: n and f(n.left) + [n.val] + f(n.right) or []

        # Calculate the minimum absolute difference

        # Obtain the list of node values using the in-order traversal
        node_values = f(root)

        # Exclude the first value since the minimum difference should be between different nodes
        excluded = node_values[1:]

        # Calculate the absolute differences between all possible pairs of node values
        diff = map(sub, excluded, node_values)

        # Create a set to remove duplicates from the absolute differences
        s = {*diff}

        # Find the minimum value from the set of unique differences
        min_difference = min(s)

        # Return the minimum difference as the result
        return min_difference