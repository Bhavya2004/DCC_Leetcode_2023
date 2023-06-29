from collections import deque
class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:


        # Step 1
        queue = deque()
        visited = set()
        keys = set()
        locks = set()
        start = None
        num_keys = 0
        rows, cols = len(grid), len(grid[0])

    # Step 2
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '@':
                    start = (i, j)
                elif grid[i][j].islower():
                    num_keys += 1

        queue.append((start, 0, tuple(keys)))
        visited.add((start, tuple(keys)))

    # Step 3
        while queue:
            curr, steps, keys = queue.popleft()

        # Step 5
            if len(keys) == num_keys:
                return steps

            x, y = curr

        # Step 7
            next_positions = [(x+1, y), (x-1, y), (x, y+1), (x, y-1)]

        # Step 8
            for nx, ny in next_positions:
                if 0 <= nx < rows and 0 <= ny < cols:
                    if grid[nx][ny] == '#':
                        continue
                    elif grid[nx][ny].islower():
                        new_keys = set(keys)
                        new_keys.add(grid[nx][ny])
                        if (nx, ny, tuple(new_keys)) not in visited:
                            queue.append(((nx, ny), steps+1, tuple(new_keys)))
                            visited.add((nx, ny, tuple(new_keys)))
                    elif grid[nx][ny].isupper():
                        if grid[nx][ny].lower() in keys:
                            if (nx, ny, tuple(keys)) not in visited:
                                queue.append(((nx, ny), steps+1, tuple(keys)))
                                visited.add((nx, ny, tuple(keys)))
                    else:
                        if (nx, ny, tuple(keys)) not in visited:
                            queue.append(((nx, ny), steps+1, tuple(keys)))
                            visited.add((nx, ny, tuple(keys)))

    # Step 10
        return -1