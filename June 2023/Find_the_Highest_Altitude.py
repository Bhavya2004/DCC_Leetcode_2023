class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        highest = 0  
        altitude = 0  

        for gain_value in gain:
            altitude += gain_value  

        # Update the highest altitude if necessary
            if altitude > highest:
                highest = altitude

        return highest