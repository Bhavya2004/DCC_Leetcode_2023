# I have Used Floyd's cycle-finding algorithm:
#1.We first initialize two pointers, slow and fast, to the head of the linked list.
#2.We then move slow one step at a time and fast two steps at a time. If there is a cycle in the linked list, eventually the fast pointer will catch up to the slow pointer, and they will be pointing to the same node. We detect this using a loop and a break statement.
#3.Once we have detected a cycle, we use two more pointers, p1 and p2, to find the node where the cycle begins. We start by initializing p1 to the head of the linked list, and p2 to the node where the fast and slow pointers met.
#4.We then move both pointers one step at a time until they meet again. The node where they meet is the start of the cycle.
#5.If there is no cycle in the linked list, the fast pointer will eventually reach the end of the list and we can return null to indicate that there is no cycle.

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        # Step 1: Find where the fast and slow pointers meet
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        # Step 2: Find the start of the cycle
        if not fast or not fast.next:
            return None  # no cycle
    
        p1 = head
        p2 = fast
        while p1 != p2:
            p1 = p1.next
            p2 = p2.next
    
        return p1