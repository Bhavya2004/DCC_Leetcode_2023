// -> k is the number of projects and w is the current capital we have
// ->initially to select a project from array,W i.e current capital should be >= than c[i]
// ->after the completion of project,w will be w + profit
// ->remember that you hav eto choose only k no. of projects.So decrement k when chosen a project 
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;

        //profit,capital
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
        for(int i=0;i<n;i++)
            pq.add(new int[]{profits[i],capital[i]});

        //take maxpq for keeping projects which can be taken with current capital w
        PriorityQueue<int[]> maxpq=new PriorityQueue<int[]>((a,b)->(b[0]-a[0]));

        while( (!pq.isEmpty() || !maxpq.isEmpty()) && k>0){
            if(!pq.isEmpty() && pq.peek()[1]<=w){
                maxpq.add(pq.poll());
            }
            else{
                if(!maxpq.isEmpty()){
                    w+=maxpq.poll()[0];
                    k--;
                }
                else{
                    break;
                }
            }
        }
        return w;
    }
}