class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        if k == 0:
            return [[]]

        result = []
        for i in range(1, n + 1):
            for combination in self.combine(i - 1, k - 1):
                result.append(combination + [i])

        return result
	