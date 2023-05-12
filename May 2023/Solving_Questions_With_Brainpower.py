class Solution(object):
    def mostPoints(self, questions):
        n = len(questions)
        res = [0] * n
        res[-1] = questions[-1][0]
        for i in range(n-2, -1, -1):
            if i + questions[i][1] + 1 >= n:
                res[i] = max(questions[i][0], res[i+1])
            else:
                res[i] = max(questions[i][0] + res[i+questions[i][1]+1], res[i+1])
        return res[0]