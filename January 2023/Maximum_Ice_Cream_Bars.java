class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int l=costs.length;

        for (int i=0;i<l;i++){
            coins -= costs[i];
            if(coins <0){
                return i;
            }
        }
        return l;
    }
}