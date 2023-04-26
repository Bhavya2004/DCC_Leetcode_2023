class Solution:
    def addDigits(self, num: int) -> int:
        while num > 9:  # Keep looping until num has only one digit
            digit_sum = 0
            for digit in str(num):  # Iterate over digits in num
                digit_sum += int(digit)  # Add digit to digit_sum
            num = digit_sum  # Update num to digit_sum
        return num