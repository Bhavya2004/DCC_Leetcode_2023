# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        heap = []
        for i, l in enumerate(lists):
            if l:
                heap.append((l.val, i))
        heapq.heapify(heap)
        dummy = ListNode(0)
        cur = dummy
        
        while heap:
            val, idx = heapq.heappop(heap)
            cur.next = lists[idx]
            lists[idx] = lists[idx].next
            if lists[idx]:
                heapq.heappush(heap, (lists[idx].val, idx))
            cur = cur.next
        
        return dummy.next