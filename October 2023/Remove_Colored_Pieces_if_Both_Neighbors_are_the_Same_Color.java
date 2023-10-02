class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0, bobMoves = 0;
        int aSegment = 0, bSegment = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                bSegment = 0;
                aSegment++;
                aliceMoves += aSegment > 2 ? 1 : 0;
            } else {
                aSegment = 0;
                bSegment++;
                bobMoves += bSegment > 2 ? 1 : 0;
            }
        }
        return aliceMoves > bobMoves;
    }
}