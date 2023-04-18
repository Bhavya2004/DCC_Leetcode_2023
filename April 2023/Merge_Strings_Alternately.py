class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ans=""

        i=0
        j=0

        while i<len(word1) and j<len(word2):
            ans+=word1[i]+word2[j]
            i+=1
            j+=1

        # if len of both words are different
        ans+=word1[i:] + word2[j:]
        return ans