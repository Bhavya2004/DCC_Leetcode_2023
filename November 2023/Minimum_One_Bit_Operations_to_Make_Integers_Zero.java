class Solution {
    public int minimumOneBitOperations(int n) {
        int res = 0; 
        for (int temp = n; temp != 0 ; temp = temp/2){ 
            res ^=temp;
        }
        return res; 
    }
}