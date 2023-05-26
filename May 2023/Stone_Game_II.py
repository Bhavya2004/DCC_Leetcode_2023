# At the beginning, a variable called M is set to 1.
# On each player's turn, they can choose to take all the stones from the first few remaining piles. The number of piles they can take from is between 1 and twice the value of M. After a player takes the stones, the maximum value between M and the number of piles they took (X) becomes the new value of M.
class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        # Memoization cache to store previously calculated results
        cache = {}

    # Recursive function to calculate maximum stones Alice can get
        def calculate(i, M):
            # Base case: if no remaining piles, Alice gets 0 stones
            if i >= len(piles):
                return 0

        # If the result for current inputs (i, M) is already in cache, return it
            if (i, M) in cache:
                return cache[(i, M)]

        # Calculate the maximum stones Alice can get for different values of X
            result = max([sum(piles[i:]) - calculate(j, max(M, j-i)) for j in range(i+1, min(2*M+i+1, len(piles)+1))] + [0])

        # Store the result in cache for future use
            cache[(i, M)] = result

            return result

    # Start the calculation with initial inputs (i=0, M=1)
        return calculate(0, 1)