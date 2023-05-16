# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        dummy = ListNode(-1, head)
        tmp = dummy
        while tmp.next and tmp.next.next:
            save = tmp.next
            tmp.next = tmp.next.next
            tmp.next.next, tmp.next.next.next = save, tmp.next.next
            tmp = tmp.next.next
            
        return dummy.next