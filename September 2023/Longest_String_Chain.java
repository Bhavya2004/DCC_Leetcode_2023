class Solution {
    public int longestStrChain(String[] words) {
        // Sort the words by length to start with shorter words.
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int maxChainLength = 1;
        
        // Create a map to store the maximum chain length ending at each word.
        Map<String, Integer> dp = new HashMap<>();
        
        // Iterate through each word in the sorted order.
        for (String word : words) {
            int currentChainLength = 1;
            
            // Generate all possible predecessors of the current word.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predecessorStr = predecessor.toString();
                
                // Check if the predecessor is in the map and update the current chain length.
                if (dp.containsKey(predecessorStr)) {
                    currentChainLength = Math.max(currentChainLength, dp.get(predecessorStr) + 1);
                }
            }
            
            // Update the map with the maximum chain length ending at the current word.
            dp.put(word, currentChainLength);
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }
        
        return maxChainLength;
    }
}
