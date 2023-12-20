class Solution {
    public int buyChoco(int[] prices, int money) {
     int ans = Integer.MAX_VALUE;
        int fin;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i != j ) {
                    int sum = prices[i] + prices[j];
                    ans = Math.min(ans, sum);
                }
            }
        }
       
        fin = money - ans;
        if(fin>=0){
        return fin;
        }
        else{
            return money;
        }
    }
}