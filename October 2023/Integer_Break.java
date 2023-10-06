class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else {
            return breakInteger(n);
        }
    }

    private int breakInteger(int n) {
        int div = n / 3;
        int mod = n % 3;
        if (mod == 1) {
            return (int)Math.pow(3, div - 1) * 4; 
        }
        int result = (int)Math.pow(3, div);
        if (mod != 0) {
            result *= mod;
        }
        return result;
    }
}