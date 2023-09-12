public class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        int deletions = 0;
        HashSet<Integer> used_frequencies = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        
        for (int freq : cnt.values()) {
            while (freq > 0 && used_frequencies.contains(freq)) {
                freq--;
                deletions++;
            }
            used_frequencies.add(freq);
        }
        
        return deletions;
    }
}