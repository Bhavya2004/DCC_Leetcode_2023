class Solution:
    def soupServings(self, n: int) -> float:

        if n >= 4276: return 1.0

        @lru_cache(None)
        def dfs(a: int, b: int)->float:

            if a <= 0 and b <= 0: return 0.5
            if a <= 0 or b <= 0: return a <= 0

            return (dfs(a-100,b)   + dfs(a-75,b-25) + 
                    dfs(a-50,b-50) + dfs(a-25,b-75))*.25
        
        return dfs(n,n)