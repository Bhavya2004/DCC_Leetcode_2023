class Solution {
    public int countNicePairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int mod = 1000000007;

        for (int num : nums) {
            int revNum = reverse(num);
            int diff = num - revNum;

            if (freqMap.containsKey(diff)) {
                count = (count + freqMap.get(diff)) % mod;
            }

            freqMap.put(diff, freqMap.getOrDefault(diff, 0) + 1);
        }

        return count;
    }

    private static int reverse(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        return revNum;
    }
}
