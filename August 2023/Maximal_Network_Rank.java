class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] connectivity = new int[n][n]; // Create a 2D array to represent connectivity
        
        // Populate the connectivity array based on roads
        for (int[] road : roads) {
            int cityA = road[0];
            int cityB = road[1];
            connectivity[cityA][cityB] = 1;
            connectivity[cityB][cityA] = 1;
        }
        
        int maxNetworkRank = 0;
        
        // Calculate the maximal network rank
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int networkRank = 0;
                
                // Sum the directly connected roads for each city
                for (int k = 0; k < n; k++) {
                    networkRank += connectivity[i][k];
                    networkRank += connectivity[j][k];
                }
                
                // Adjust if the cities are directly connected
                networkRank -= connectivity[i][j];
                
                maxNetworkRank = Math.max(maxNetworkRank, networkRank);
            }
        }
        
        return maxNetworkRank;
    }
}
