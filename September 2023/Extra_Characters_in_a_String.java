// DP Approach (Working)
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = n - i; // max possible value thi initialize 

            for (String word : dictionary) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i + len]);
                }
            }
            
            dp[i] = Math.min(dp[i], 1 + dp[i + 1]); 
        }

        return dp[0]; 
    }
}


// Recursion Approach (TLE)
/*
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        return breakString(s, dictionary, 0);
    }
    
    public int breakString(String s, String[] dictionary, int start) {
        if (start == s.length()) {
            // jo string na end ma pochi gya to ekai extra character nathi
            return 0;
        }
        
        int minExtra = Integer.MAX_VALUE;
        
        for (String word : dictionary) {
            int end = start + word.length();
            
            if (end <= s.length() && s.substring(start, end).equals(word)) {
                // jo word match thai gya to extra calculate karvana
                int extra = end - start - word.length();
                int result = breakString(s, dictionary, end);
                minExtra = Math.min(minExtra, extra + result);
            }
        }
        
        // jo word match nathi thata to next character ma javanu 
        int result = breakString(s, dictionary, start + 1);
        minExtra = Math.min(minExtra, 1 + result);
        
        return minExtra;
    }
}
*/