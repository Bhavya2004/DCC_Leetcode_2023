# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:

        left = head
        for i in range(1,k):
            left = left.next

        right = head
        curr = left

        while curr.next:
            curr = curr.next
            right = right.next

        left.val , right.val = right.val , left.val

        return head