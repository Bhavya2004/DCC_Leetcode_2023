class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        l = []
        cur = 0
        for i in pushed:
            l.append(i)
            while l and cur < len(popped) and l[-1] == popped[cur]:
                cur += 1
                l.pop()
        return cur == len(popped)