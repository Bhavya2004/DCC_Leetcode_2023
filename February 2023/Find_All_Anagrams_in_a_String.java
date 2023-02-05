import java.util.ArrayList;
import java.util.List;

// we will creates two arrays arrs and arrp with 26 elements, 
// representing the count of each letter from 'a' to 'z' in s and p respectively.

// For each substring of s with length m (the length of p), it compares the letter count in the substring
//  and arrp. If all elements in arrs and arrp are the same,it means this substring is an anagram of p,
//  so the starting index of this substring is added to the list ans.
	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = p.length();
			if(m>n){
                return ans;
            }
			int []arrs = new int[26];
			int []arrp = new int[26];
			for(int i=0;i<m;i++){
				arrs[s.charAt(i)-'a']++;
				arrp[p.charAt(i)-'a']++;
			}
			for(int i=0;i<=n-m;i++){
				boolean flag = true;
				for(int j=0;j<26;j++){
					if(arrs[j]!=arrp[j]){
						flag = false;
						break;
					}
				}
				if(flag==true){
                    ans.add(i);
                }
				arrs[s.charAt(i)-'a']--;
				if(i+m < n){
                    arrs[s.charAt(i+m)-'a']++;
                }
			}
			return ans;
		}
	}