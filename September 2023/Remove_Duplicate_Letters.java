class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = getLastIndex(s);
        boolean[] seen = new boolean[26];
        StringBuilder stb = new StringBuilder();
        int codePoint;
        char ch, charToRemove;
        for (int i = 0; i < s.length(); i++) {
            codePoint = (ch = s.charAt(i)) - 'a';
            if (seen[codePoint]) {
                continue;
            }
            while(stb.length() > 0 && stb.charAt(stb.length() - 1) > ch && lastIndex[stb.charAt(stb.length() - 1) - 'a'] > i) {
                charToRemove = stb.charAt(stb.length() - 1);
                stb.setLength(stb.length() - 1);
                seen[charToRemove - 'a'] = false;
            }
            stb.append(ch);
            seen[codePoint] = true;
        }
        return stb.toString();
    }

    private int[] getLastIndex(String s) {
        int[] lastIndex =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        return lastIndex;
    }
}