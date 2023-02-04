class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char ch : s1.toCharArray()){
            arr1[ch - 'a']++;
        }
        for (int i = 0; i < n2; i++)
        {
            arr2[s2.charAt(i) - 'a']++;
            if (i >= n1){
                arr2[s2.charAt(i - n1) - 'a']--;
            }
            if (Arrays.equals(arr1, arr2))
                return true;
        }
        return false;
    }
}