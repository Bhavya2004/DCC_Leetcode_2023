# The last element of the postorder array will always be the root of the binary tree
# Find the index of the root element in the inorder array. This index will divide the inorder array into left and right subtrees.
# The elements to the left of the root index in the inorder array will be the elements of the left subtree, and the elements to the right of the root index will be the elements of the right subtree.
# Recursively construct the left and right subtrees using the left and right partitions of the inorder array and the corresponding partitions of the postorder array.
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return None
        
        root_val = postorder[-1]
        root_index = inorder.index(root_val)
        
        left_inorder = inorder[:root_index]
        right_inorder = inorder[root_index+1:]
        
        left_postorder = postorder[:root_index]
        right_postorder = postorder[root_index:-1]
        
        root = TreeNode(root_val)
        root.left = self.buildTree(left_inorder, left_postorder)
        root.right = self.buildTree(right_inorder, right_postorder)
        
        return root