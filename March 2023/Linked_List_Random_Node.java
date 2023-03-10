
class Solution {
    private ListNode head;
     // a Random object that we'll use to generate random numbers
    private Random rand;

    public Solution(ListNode head) {
        this.head=head;
        this.rand=new Random();
    }
    
    public int getRandom() {
        ListNode curr = head;
        int result = curr.val;
        int count = 1;
        
        while (curr != null) {
            // Generate a random number between 1 and the number of nodes seen so far   (including current node)
            if (rand.nextInt(count) == 0) {
                // If the generated number is 1, update the result variable to the value of the current node
                result = curr.val;
            }
            count++;
            curr = curr.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */