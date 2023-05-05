class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = set(['a', 'e', 'i', 'o', 'u'])
        max_count = 0
        count = 0
        for i in range(len(s)):
            if i >= k and s[i-k] in vowels:
                count -= 1
            if s[i] in vowels:
                count += 1
            if count > max_count:
                max_count = count
        return max_count

# One Liner Solution :
        # return max(map(sub,(X:=[*accumulate([i in 'aeiou' for i in "!"+s])])[k:],X))