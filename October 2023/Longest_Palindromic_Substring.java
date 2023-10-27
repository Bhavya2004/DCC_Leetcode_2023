class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String current = s.substring(i, j);
                int left = 0;
                int right = current.length() - 1;
                boolean isPalindrome = true;
                
                while (left < right) {
                    if (current.charAt(left) != current.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }
                
                if (isPalindrome && current.length() > longest.length()) {
                    longest = current;
                }
            }
        }
        
        return longest;
    }
}
