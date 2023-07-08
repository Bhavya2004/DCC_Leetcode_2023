class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:

        l = sorted(i+j for i, j in zip(weights, weights[1:]))
        return sum(l[::-1][:k-1]) - sum(l[:k-1])