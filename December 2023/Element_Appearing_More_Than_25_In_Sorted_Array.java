class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int target = n / 4;
        
        for (int i = 0; i < n - target; i++) {
            if (arr[i] == arr[i + target]) {
                return arr[i];
            }
        }
        
        return -1; // Special integer not found
    }
}