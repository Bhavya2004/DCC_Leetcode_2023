class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # bin() is used to convert specified int into binary
        # here int(value,base) is used to convert number to int number to base 2 
        return str(bin(int(a, 2) + int(b, 2)))[2:]