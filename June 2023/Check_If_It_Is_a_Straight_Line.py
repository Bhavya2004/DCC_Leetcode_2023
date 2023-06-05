# The property that can be used to solve this problem is that the slope between any two points on a straight line will be the same. 
class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
    
        if len(coordinates) <= 2:
            return True

        x0, y0 = coordinates[0]
        x1, y1 = coordinates[1]
        for i in range(2, len(coordinates)):
            x, y = coordinates[i]
            # Slope formula
            if (y1 - y0) * (x - x0) != (y - y0) * (x1 - x0):
                return False

        return True
        
             