class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int c = 0;
        while(Math.pow(minutesToTest/minutesToDie + 1, c) < buckets) {
            c++;
        }
        return c;
    }
}