# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        l = []
        while head is not None:
            l.append(head.val)
            head = head.next
        ans = 0
        for i in range(len(l)//2):
            ans = max(ans, l[i]+l[-i-1])
        return ans