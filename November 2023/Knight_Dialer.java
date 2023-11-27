class Solution {
    static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        long[] curPos = new long[10];
        Arrays.fill(curPos, 1);

        for (int jump = 2; jump <= n; jump++) {
            long[] newPos = new long[10];

            // Calculate the new positions based on the valid knight moves
            newPos[0] = (curPos[6] + curPos[4]) % MOD;
            newPos[1] = (curPos[6] + curPos[8]) % MOD;
            newPos[2] = (curPos[7] + curPos[9]) % MOD;
            newPos[3] = (curPos[4] + curPos[8]) % MOD;
            newPos[4] = (curPos[0] + curPos[3] + curPos[9]) % MOD;
            newPos[5] = 0;  // Knight cannot move to position 5
            newPos[6] = (curPos[0] + curPos[1] + curPos[7]) % MOD;
            newPos[7] = (curPos[2] + curPos[6]) % MOD;
            newPos[8] = (curPos[1] + curPos[3]) % MOD;
            newPos[9] = (curPos[2] + curPos[4]) % MOD;

            // Update the current positions array for the next iteration
            curPos = newPos;
        }

        // total count of distinct phone numbers
        long totalCount = 0;
        for (int i = 0; i < 10; i++) {
            totalCount = (totalCount + curPos[i]) % MOD;
        }

        return (int) totalCount;
    }
}