class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
    
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
        
            if (firstIndex[index] == -1) {
                firstIndex[index] = i;
            } else {
                maxLength = Math.max(maxLength, i - firstIndex[index] - 1);
            }
        }
    
        return maxLength;
        }
}