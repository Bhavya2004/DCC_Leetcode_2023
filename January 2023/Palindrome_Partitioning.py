class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        
        def backtrack(i, path):
            if i == len(s):
                res.append(path.copy())
            
            for j in range(i, len(s)):
                if s[i:j+1] == s[i:j+1][::-1]:
                    backtrack(j+1, path+[s[i:j+1]])
        
        backtrack(0, [])
        return res
