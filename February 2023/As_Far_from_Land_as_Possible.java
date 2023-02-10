//In grid problem we will use two DP i.e. from top,left and bottom,right
class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x= n+m;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    continue; //if 1 comes,it means land so skip it as we have to find water cells only
                }  
                int top=x;
                int left=x;
                if(i-1>=0) top=grid[i-1][j];
                if(j-1>=0) left=grid[i][j-1];
                grid[i][j]=Math.min(top,left)+1;
            }
        }   
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1) {
                    continue;
                }
                int bottem=x;
                int right=x;
                if(i+1<m) bottem=grid[i+1][j];
                if(j+1<n) right=grid[i][j+1];
                grid[i][j]=Math.min(grid[i][j],Math.min(bottem,right)+1);
            }
        }      
        int count=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count=Math.max(count,grid[i][j]);
                }
            }
        return count-1==n+m+1||count-1==0 ? -1: count-1;
    }
}