class Solution {
    public boolean makeEqual(String[] words) {
    Map<Character, Integer> count = new HashMap<>();

    for (String word : words) {
        for (char c : word.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
    }

    for (int value : count.values()) {
        if (value % words.length != 0) {
            return false;
        }
    }

    return true;
    }
}