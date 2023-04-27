class Solution:
    def bulbSwitch(self, n: int) -> int:
        #first of all find the factors of 1 to n.than find the numbers which has odd number of factors(reject no. with even number of factors).At last return the count of number having odd no. of factors. 
        # the above all process gives the same ans as when we find the square root of n

        return int(math.sqrt(n))