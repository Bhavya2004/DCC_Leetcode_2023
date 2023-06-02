class Solution:
    def maximumDetonation(self, bo: List[List[int]]) -> int:
        n = len(bo)  # Number of bombs
        l = [set() for i in range(n)]  # List to store bombs within range for each bomb

        # Calculate bombs within range for each bomb
        for i in range(n):
            a, b, r = bo[i]
            for j in range(n):
                x, y, t = bo[j]
                k = sqrt((a - x) ** 2 + (b - y) ** 2)
                if k <= r:
                    l[i].add(j)

        # Depth-first search to find maximum number of bombs that can be detonated
        def f(i):
            vis.add(i)
            for j in l[i]:
                if j in vis:
                    continue
                f(j)

        m = 1  # Maximum number of bombs that can be detonated
        for i in range(n):
            vis = set()
            f(i)
            m = max(m, len(vis))

        return m