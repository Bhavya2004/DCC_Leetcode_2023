# Iterate over the bits of a, b, and c simultaneously, comparing each corresponding bit.
# If the bit in c is 0 and either bit in a or b is 1, increment flips by 1.
# If the bit in c is 1 and both bits in a and b are 0, increment flips by 1.
class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        flips = 0
        while a > 0 or b > 0 or c > 0:
            bit_a = a & 1  # Get the least significant bit of a
            bit_b = b & 1  # Get the least significant bit of b
            bit_c = c & 1  # Get the least significant bit of c

            if bit_c == 0:
                if bit_a | bit_b == 1:  # If either bit is 1, a flip is required
                    flips += (bit_a + bit_b)
            else:
                if bit_a == 0 and bit_b == 0:  # If both bits are 0, a flip is required
                    flips += 1

            a >>= 1  # Right shift a by 1 bit
            b >>= 1  # Right shift b by 1 bit
            c >>= 1  # Right shift c by 1 bit

        return flips

