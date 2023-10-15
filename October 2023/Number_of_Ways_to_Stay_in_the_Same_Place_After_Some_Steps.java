class Solution {
    public int numWays(int steps, int arrLen) {
        Map<Integer, Integer>[] ways = new Map[arrLen];
        return calculateWays(0, steps, arrLen, ways);
    }

    private int calculateWays(int index, int remainingSteps, int arrLen, Map<Integer, Integer>[] ways) {
        if (index < 0 || index >= arrLen || index > remainingSteps) {
            return 0;
        }
        if (remainingSteps == 0) {
            return index == 0 ? 1 : 0;
        }
        if (ways[index] == null) {
            ways[index] = new HashMap<>();
        }
        Integer sum = ways[index].get(remainingSteps);
        if (sum == null) {
            sum = calculateWays(index - 1, remainingSteps - 1, arrLen, ways) + calculateWays(index + 1, remainingSteps - 1, arrLen, ways);
            sum = (sum % 1_000_000_007 + calculateWays(index, remainingSteps-1, arrLen, ways)) % 1_000_000_007;
            ways[index].put(remainingSteps, sum);
        }
        return sum;
    }
}