/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode pre = null;
        int c = 1;
        while(temp != null){
            if( c == left ){
                ListNode newHead = temp;
                ListNode newTail = pre;
                while( c <= right ){
                    ListNode nextNode = temp.next;
                    temp.next = pre;
                    pre = temp;
                    temp = nextNode;
                    c++;
                }
                if(newTail != null) newTail.next = pre;
                newHead.next = temp;
                if( left == 1 ) return pre;
            }
            else{
                c++;
                pre = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}