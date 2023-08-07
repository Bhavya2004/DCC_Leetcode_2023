class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # One-liner:
        # return target in chain.from_iterable(matrix)
        if not matrix or not matrix[0]:
            return False
        
        rows, cols = len(matrix), len(matrix[0])
        start, end = 0, rows * cols - 1
        
        while start <= end:
            mid = (start + end) // 2
            mid_value = matrix[mid // cols][mid % cols]
            
            if mid_value == target:
                return True
            elif mid_value < target:
                start = mid + 1
            else:
                end = mid - 1
        
        return False
