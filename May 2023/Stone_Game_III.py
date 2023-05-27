class Solution:
    def stoneGameIII(self, stoneValue):
        n = len(stoneValue)
        dp = [0] * 3  # DP array to store the maximum score difference at each position

        # Iterate backwards from the last stone
        for i in range(n - 1, -1, -1):
            # Calculate the score difference if Alice takes one stone
            take_one = stoneValue[i] - dp[(i + 1) % 3]

            take_two = float('-inf')  # Initialize with negative infinity
            if i + 1 < n:
                # Calculate the score difference if Alice takes two stones
                take_two = stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 3]

            take_three = float('-inf')  # Initialize with negative infinity
            if i + 2 < n:
                # Calculate the score difference if Alice takes three stones
                take_three = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 3]

            # Store the maximum score difference at the current position
            dp[i % 3] = max(take_one, take_two, take_three)

        score_diff = dp[0]  # Get the score difference at the starting position

        # Determine the winner based on the score difference
        if score_diff > 0:
            return "Alice"
        elif score_diff < 0:
            return "Bob"
        else:
            return "Tie"