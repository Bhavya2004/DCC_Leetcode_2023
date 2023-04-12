class Solution:
    def simplifyPath(self, path: str) -> str:
        l = []
        for i in path.split('/'):
            if i=='..':
                if l:
                    l.pop()
            elif i and i!='.':
                l.append(i)
        return '/'+'/'.join(l)