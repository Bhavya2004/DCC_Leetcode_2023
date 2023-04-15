class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        # out of all the piles indexed up to pile, and i have rem coins left, what's the maximum total
        
        # Number of states: n * k
        # Transition: len(pile) which can be up to 2000
        # total complexity is n * k * 2000
        
        # For any pile, len(pile) * k
        # total complexity = k * len(pile[0]) + k*len(pile[1]) + ....
        # = k*(len(pile[0])+len(pile[1])+....)
        # = k*(2000+n)
        
        @cache
        def ans(pile, rem):
            if rem < 0:
                return -inf
            if pile < 0:
                if rem == 0:
                    return 0
                return -inf
            res = ans(pile-1, rem)
            cur = 0
            for i in range(len(piles[pile])):
                cur += piles[pile][i]
                res = max(res, cur+ans(pile-1, rem-i-1))
            return res
        return ans(len(piles)-1, k)
    
    