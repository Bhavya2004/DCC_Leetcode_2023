# Create an empty set 's' to store all the words in the given array of strings.
# Iterate through the array of strings and insert each word into the set 's'.
# Create an empty vector 'concatenateWords' to store all the concatenated words.
# Iterate through the array of strings again, for each word, check if it is a concatenated word using the function 'checkConcatenate(word)'.
# In the 'checkConcatenate(word)' function, use a for loop to iterate through each substring of the word, starting from index 1 to the second last index of the word.
# For each substring, check if the prefix and suffix of the substring exists in the set 's'.
# If the prefix and suffix both exist in the set 's', then return true, indicating that the word is a concatenated word.
# If the function 'checkConcatenate(word)' returns true, then insert the word into the 'concatenateWords' vector.
# Return the 'concatenateWords' vector.
class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        s = set()
        concatenateWords = []
        for word in words:
            s.add(word)
        for word in words:
            if self.checkConcatenate(word, s) == True:
                concatenateWords.append(word)
        return concatenateWords
    def checkConcatenate(self, word: str, s: set) -> bool:
        for i in range(1, len(word)):
            prefixWord = word[:i]
            suffixWord = word[i:]
            if prefixWord in s and (suffixWord in s or self.checkConcatenate(suffixWord, s)):
                return True
        # return False