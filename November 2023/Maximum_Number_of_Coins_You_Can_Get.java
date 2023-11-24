import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int maxCoins = 0;
        
        for (int i = piles.length - 2; i >= n; i -= 2) {
            maxCoins += piles[i];
        }
        
        return maxCoins;
    }
}
