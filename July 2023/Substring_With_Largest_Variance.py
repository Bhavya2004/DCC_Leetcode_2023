class Solution:
    def largestVariance(self, s: str) -> int:
        count1 = 0
        count2 = 0
        max_variance = 0
        
        # create distinct list of character pairs
        pairs = [(l1, l2) for l1 in set(s) for l2 in set(s) if l1 != l2]

        # run once for original string order, then again for reverse string order
        for runs in range(2):
            for pair in pairs:
                count1 = count2 = 0
                for letter in s:
                    # no reason to process letters that aren't part of the current pair
                    if letter not in pair:
                        continue
                    if letter == pair[0]:
                        count1 += 1
                    elif letter == pair[1]:
                        count2 += 1
                    if count1 < count2:
                        count1 = count2 = 0
                    elif count1 > 0 and count2 > 0:
                        max_variance = max(max_variance, count1 - count2)
                
            
            # reverse the string for the second time around
            s = s[::-1]
                
        return max_variance