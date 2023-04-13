class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        
        return len(word) <= 1 or word.isupper() or word[1:].islower()