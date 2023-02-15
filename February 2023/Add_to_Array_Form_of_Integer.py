class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:

        # Step 1: Convert the array form of the integer into an actual integer.
        n = 0
        for digit in num:
            n = n * 10 + digit
    
        # Step 2: Add k to the integer.
        n += k
    
        # Step 3: Convert the result back into an array form.
        result = []
        while n > 0:
            digit = n % 10
            result.append(digit)
            n //= 10
        result.reverse()
    
        # Step 4: Return the array form.
        return result