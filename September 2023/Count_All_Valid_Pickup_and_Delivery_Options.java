import java.util.HashMap;
import java.util.Map;

class Solution {
    static final int MOD = 1000000007;
    Map<String, Integer> memo = new HashMap<>();

    public int countOrders(int n) {
        return totalWays(n, n);
    }

    public int totalWays(int unpicked, int undelivered) {
        String key = unpicked + "-" + undelivered;

        if (!memo.containsKey(key)) {
            if (unpicked == 0 && undelivered == 0) {
                // We have completed all orders.
                memo.put(key, 1);
            } else if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
                // We can't pick or deliver more than N items
                // Number of deliveries can't exceed the number of pickups
                // as we can only deliver after a pickup.
                memo.put(key, 0);
            } else {
                // Count all choices of picking up an order.
                long ans = (long) unpicked * totalWays(unpicked - 1, undelivered);
                ans %= MOD;

                // Count all choices of delivering a picked order.
                ans += (long) (undelivered - unpicked) * totalWays(unpicked, undelivered - 1);
                ans %= MOD;

                memo.put(key, (int) ans);
            }
        }

        return memo.get(key);
    }
}
