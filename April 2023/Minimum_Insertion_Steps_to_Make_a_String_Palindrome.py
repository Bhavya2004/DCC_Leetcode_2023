class Solution:
    def minInsertions(self, s: str) -> int:
        # Get the length of the string
        n = len(s)
        
        # Initialize an array to store the number of insertions required at each position
        dp = [0] * n

        # Iterate backwards through the string from the second-to-last character to the first character
        for i in range(n-2, -1, -1):
            # Initialize a variable to store the value of dp[j-1]
            prev = 0

            # Iterate forwards through the string from the current character to the last character
            for j in range(i+1, n):
                # Store the current value of dp[j] in a temporary variable
                temp = dp[j]

                # If the characters at the current position i and j match, set dp[j] to the value of dp[j-1]
                if s[i] == s[j]:
                    dp[j] = prev

                # If the characters at the current position i and j do not match, set dp[j] to the minimum of dp[j] and dp[j-1] plus one
                else:
                    dp[j] = min(dp[j], dp[j-1]) + 1

                # Update the value of prev to the previous value of dp[j]
                prev = temp

        # Return the minimum number of insertions required to make the entire string a palindrome
        return dp[n-1]
