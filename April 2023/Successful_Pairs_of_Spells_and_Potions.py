class Solution:
    def successfulPairs(self, spells, potions, success):
        sorted_potions = sorted(potions)
        result = []
        for a in spells:
            count = len(sorted_potions) - bisect_left(sorted_potions, (success + a - 1) // a)
            result.append(count)
        return result