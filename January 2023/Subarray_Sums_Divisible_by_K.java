class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, remainder; i < nums.length; i++) {
            if (i > 0) nums[i] += nums[i - 1];
            //main logic:-
            remainder = (nums[i] % k + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        int result = map.getOrDefault(0, 0);
        for (int frequency : map.values())
            result += frequency * (frequency - 1) / 2;
        return result;
    }
}