class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        
        // Sort the pairs based on the second element in each pair
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pairs[i][1] > pairs[j][1]) {
                    // Swap pairs[i] and pairs[j]
                    int[] temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
                }
            }
        }
        
        int total = 1;
        int[] last = pairs[0];
        
        for (int i = 0; i < n; i++) {
            if (pairs[i][0] > last[1]) {
                last = pairs[i];
                total++;
            }
        }
        
        return total;
    }
}
