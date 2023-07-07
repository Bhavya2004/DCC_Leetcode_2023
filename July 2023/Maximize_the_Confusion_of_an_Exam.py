class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        n, ans1, l, k1 = len(answerKey), 0, 0, k
        for r, ith in enumerate(answerKey):
            if ith == 'F':
                if k1 == 0:
                    while answerKey[l] != 'F':
                        l += 1
                    l += 1
                else:
                    k1 -= 1
            ans1 = max(ans1, r-l+1)
        
        ans2, k2, l = 0, k, 0
        for r, ith in enumerate(answerKey):
            if ith == 'T':
                if k2 == 0:
                    while answerKey[l] != 'T':
                        l += 1
                    l += 1
                else:
                    k2 -= 1
            ans2 = max(ans2, r-l+1)
    
        return max(ans1, ans2)
                    