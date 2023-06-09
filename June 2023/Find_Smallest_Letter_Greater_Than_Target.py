class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        return (letters + letters)[bisect_right(letters,target)]