class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        int mod = 1000000007;
        long ans = 0;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int len = j - i;
            ans += (long) len * (len + 1) / 2;
            ans %= mod;
            i = j;
        }
        return (int) ans;
    }
}