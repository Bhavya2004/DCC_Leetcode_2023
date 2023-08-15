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
    // will create 2 seperate LL,one containing val less than target & other containing val >= target there by PRESERVING THE ORDER IN WHICH THEY ARE.
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);  //1ST LL
        ListNode higher = new ListNode(0); //2nd LL
        
        ListNode smallHead=small, higherHead = higher; //Head pointers
        
        while(head!=null){
            if(head.val<x){
                //small list
                smallHead.next = head;
                smallHead = smallHead.next;
            }
            else{
                //high list
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head=head.next;
        }
        
        higherHead.next = null;
        smallHead.next = higher.next; //combine both
        
        return small.next;
        
    }
}