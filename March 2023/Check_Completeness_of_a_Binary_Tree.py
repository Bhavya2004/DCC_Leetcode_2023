#1. Initialize a queue and add the root node to the queue.
#2. While the queue is not empty, pop the first element from the queue and check if it is null. If it is null, set a flag end to True. If it is not null, add its left and right child nodes to the queue.
#3. Check if the end flag is True. If it is True, we have reached the end of the complete binary tree, and we should not encounter any non-null nodes after this. So, we check if there are any non-null nodes in the remaining nodes in the queue. If there are, the binary tree is not complete, and we return False.
#4. If the queue is empty, we have processed all the nodes, and the binary tree is complete. So, we return True.
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        queue = [root]
        end = False
        while queue:
            node = queue.pop(0)
            if not node:
                end = True
            else:
                if end:
                    return False
                queue.append(node.left)
                queue.append(node.right)

        return True