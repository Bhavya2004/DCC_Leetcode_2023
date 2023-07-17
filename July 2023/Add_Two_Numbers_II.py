class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # Reverse both linked lists
        l1 = self.reverseLinkedList(l1)
        l2 = self.reverseLinkedList(l2)
        
        # Initialize variables
        dummy = ListNode(0)
        current = dummy
        carry = 0
        
        # Traverse both linked lists
        while l1 or l2 or carry:
            # Get the values of the current nodes
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            # Calculate the sum and carry-over
            total = val1 + val2 + carry
            carry = total // 10
            digit = total % 10
            
            # Create a new node with the sum
            current.next = ListNode(digit)
            current = current.next
            
            # Move to the next nodes
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        
        # Reverse the result linked list
        result = self.reverseLinkedList(dummy.next)
        
        return result
    
    def reverseLinkedList(self, head: ListNode) -> ListNode:
        prev = None
        current = head
        
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        
        return prev
