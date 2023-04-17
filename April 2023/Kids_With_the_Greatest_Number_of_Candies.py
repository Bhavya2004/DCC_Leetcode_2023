class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        ans=[]
        for candy in candies:
            now=candy+extraCandies

            b=True
            for candy2 in candies:
                if now<candy2:
                    b=False

            ans.append(b)

        return ans            