class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dict={
            "2":"abc",
            "3":"def",
            "4":"ghi",
            "5":"jkl",
            "6":"mno",
            "7":"pqrs",
            "8":"tuv",
            "9":"wxyz",
        }

        if not digits:
            return []
        
        output=[""]

        for d in digits:
            tmp=[]
            for v in dict[d]:
                for o in output:
                    tmp.append(o+v)
            output=tmp
        return output
        