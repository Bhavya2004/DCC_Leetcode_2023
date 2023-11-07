class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[][] monsters = new int[n][2];
        for (int i = 0; i < n; i++) {
            monsters[i][0] = dist[i];
            monsters[i][1] = speed[i];
        }
        Arrays.sort(monsters, (a, b) -> Double.compare((double) a[0] / a[1], (double) b[0] / b[1]));
        int eliminated = 0;
        double time = 0;
        for (int[] monster : monsters) {
            int monsterDist = monster[0];
            int monsterSpeed = monster[1];
            double monsterTime = (double) monsterDist / monsterSpeed;
            if (time >= monsterTime) {
                break;
            }
            eliminated++;
            time += 1; // Charge the weapon for 1 minute
        }
        return eliminated;
    }
}
