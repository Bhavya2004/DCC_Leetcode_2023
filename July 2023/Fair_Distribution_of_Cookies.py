class Solution(object):
    def distributeCookies(self, cookies, k):
        self.ans = float('inf')
        self.kids = [0] * k
        
        def backtrack(i):
            if i == len(cookies):
                self.ans = min(self.ans, max(self.kids))
                return
            
            seen = set()
            for j in range(k):
                if self.kids[j] in seen: # pruning condition 1
                    continue
                if self.kids[j] + cookies[i] > self.ans: # pruning condition 2
                    continue
                seen.add(self.kids[j])
                self.kids[j] += cookies[i]
                backtrack(i + 1)
                self.kids[j] -= cookies[i]
                
        backtrack(0)
        return self.ans