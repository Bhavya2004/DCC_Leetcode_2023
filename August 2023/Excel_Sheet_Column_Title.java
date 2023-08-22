class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder stb = new StringBuilder();
        char[] mods = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
        'W','X','Y','Z'};
        while(columnNumber > 0) {
            stb.append(mods[(columnNumber -1) % 26]);
            columnNumber = (columnNumber -1) / 26;
        }
        return stb.reverse().toString();
    }
}