class Solution {
    public String decodeAtIndex(String S, int K) {
        int i;
        long N = 0;
        for (i = 0; N < K; i++) {
            N = Character.isDigit(S.charAt(i)) ? N * (S.charAt(i) - '0') : N + 1;
        }
        for (i--; i > 0; i--) {
            if (Character.isDigit(S.charAt(i))) {
                N /= S.charAt(i) - '0';
                K %= N;
            }
            else {
                if (K % N == 0) {
                    break;
                }
                N--;
            }
        }
        return Character.toString(S.charAt(i));
    }
}