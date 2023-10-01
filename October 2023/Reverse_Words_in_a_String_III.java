class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        for (int i = 0; i < ch.length; i++) {
            if (s.charAt(i) == ' ') {
                reverseChars(ch, left, i-1);
                left = i + 1;
            }
        }
        reverseChars(ch, left, s.length() - 1);
        return new String(ch);
    }

    private void reverseChars(char[] ch, int from, int end) {
        char temp;
        while (from < end) {
            temp = ch[from];
            ch[from++] = ch[end];
            ch[end--] = temp;
        }
    }
}