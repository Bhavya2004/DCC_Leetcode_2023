class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                StringBuilder p = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    p.append(s.substring(0, i));
                }
                if (s.equals(p.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}