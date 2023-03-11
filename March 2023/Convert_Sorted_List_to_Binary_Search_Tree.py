# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        L = []
        while head:
            L.append(head.val)
            head = head.next
        def ans(l, r):
            if l > r:
                return None
            m = (l+r) >> 1
            return TreeNode(L[m], ans(l, m-1), ans(m+1, r))
        return ans(0, len(L)-1)