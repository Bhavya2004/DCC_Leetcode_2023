class Solution {
    public boolean isPowerOfFour(int n) {
        for (int i = 0; i <= 15; i++) {
            int power = (int) Math.pow(4, i);
            if (power == n)
                return true;
            if (power > n)
                return false;
        }
        return false;
    }
}