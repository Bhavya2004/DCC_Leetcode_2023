class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        
        n, m = len(haystack), len(needle)
        
        if n < m:
            return -1
        
        i = 0
        while i <= n - m:
            # I have used string slicing here,by default it has three arguments:[start:end:step]
            if haystack[i:i+m] == needle:
                return i
            i += 1
        
        return -1
#Note:This problem can also be solved using KMP algorithm.