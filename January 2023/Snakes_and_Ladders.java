class Solution {
    int length = 1;
    int [][] board;
    public int snakesAndLadders(int[][] board) {
        this.board = board;
        length = board.length;
        HashMap<Integer,Integer> visited = new HashMap();
        visited.put(1,0);
        Queue<Integer> arr = new LinkedList<>();
        arr.add(1);
        while (!arr.isEmpty()){
            int n = arr.remove();
            for(int i = n+1;i<=n+6;i++){
                int next = i;
                int nextPos = getPosition(i);
                if(next>length*length) return -1;
                if(nextPos!=-1){
                    next = nextPos;
                }
                if(next==length*length) return visited.get(n)+1;
                if(!visited.containsKey(next)){
                    visited.put(next,visited.get(n)+1 );
                     arr.add(next);
                }   
            }
            
        }
        return -1;
    }

    public int getPosition(int n){
        int row = (n-1)/length;
        int column = (n-1)%length;
        if(row%2!=0){
            column = (column-length+1)*-1;
        }
        row = (row-length+1)*-1;
        
        int  result = board[row][column];
        return result;
    }
}