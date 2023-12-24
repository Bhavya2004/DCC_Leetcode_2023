public class Solution {
    public int minOperations(String s) {
        int countForAlternate0 = 0;
        int countForAlternate1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    countForAlternate1++;
                } else {
                    countForAlternate0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    countForAlternate1++;
                } else {
                    countForAlternate0++;
                }
            }
        }

        return Math.min(countForAlternate0, countForAlternate1);
    }
}