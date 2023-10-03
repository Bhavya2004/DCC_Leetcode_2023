class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;

        
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        
        for (int count : countMap.values()) {
            if (count > 1) {
                goodPairs += (count * (count - 1)) / 2;
            }
        }

        return goodPairs;
    }
}
