class Solution {
    public String largestGoodInteger(String num) {
        String maxGoodInteger = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String substring = num.substring(i, i + 3);
            if (isGoodInteger(substring) && substring.compareTo(maxGoodInteger) > 0) {
                maxGoodInteger = substring;
            }
        }
        return maxGoodInteger;
    }

     private static boolean isGoodInteger(String num) {
        char digit = num.charAt(0);
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != digit) {
                return false;
            }
        }
        return true;
    }
}