# First add all non star element to a stack
# Whenever any star is encountered,pop the last element from the stack
# at last after the whole string is done,return the stack
# Time Complexity: O(n)
class Solution:
    def removeStars(self, s: str) -> str:

        res=[]

        for i in s:
            if i != "*":
                res.append(i)
            elif res:  #this condition is to check if stack is not empty
                res.pop()
        return "".join(res)