class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        z = sum(a != b for a, b in zip(s, goal))
        return Counter(s)==Counter(goal) and (z == 2 or (z == 0 and len(set(s))!=len(s)))