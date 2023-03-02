class Solution:
    def compress(self, chars: List[str]) -> int:
        i = 0 # index to write compressed character to
        j = 0 # index of current group of repeating characters
        while j < len(chars):
            k = j + 1
            while k < len(chars) and chars[k] == chars[j]:
                k += 1 # find the end of the current group
            chars[i] = chars[j] # write the compressed character
            i += 1
            if k - j > 1: # if the group has length > 1
                countStr = str(k - j) # convert count to string
                for l in range(len(countStr)): # write each digit of count
                    chars[i] = countStr[l]
                    i += 1
            j = k # move to the next group
        return i # return the new length of the array
