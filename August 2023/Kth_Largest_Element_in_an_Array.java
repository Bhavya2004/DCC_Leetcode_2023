import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        
        for (int num : nums) {
            p.offer(num);//it simply maintains the heap property automatically i.e smallest element will be at first 
            if (p.size() > k) {
                p.poll();//remove first element which will be smallest
            }
        }
        
        return p.peek(); //return last element which will be kth largest
    }
}