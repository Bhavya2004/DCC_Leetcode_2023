class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        # Get the dimensions of the grid
        rows, cols = len(grid), len(grid[0])

        # Store the two islands as sets
        islands = [set(), set()]

        # Define the directions to explore neighbors
        DIRECTIONS = [0, 1, 0, -1, 0]

        # Depth-first search to identify the islands
        def dfs(row, col, island_idx):
            for k in range(4):
                # Explore the neighboring cells
                new_row, new_col = row + DIRECTIONS[k], col + DIRECTIONS[k+1]

                # Check if the new cell is within bounds and is part of the current island
                if 0 <= new_row < rows and 0 <= new_col < cols and grid[new_row][new_col] == 1 and (new_row, new_col) not in islands[island_idx]:
                    # Add the cell to the current island and continue exploration
                    islands[island_idx].add((new_row, new_col))
                    dfs(new_row, new_col, island_idx)

        # Find the two islands
        island_count = 0
        for i in range(rows):
            if island_count == 2:
                break
            for j in range(cols):
                if grid[i][j] == 1:
                    if island_count and (i, j) in islands[0]:
                        continue
                    islands[island_count].add((i, j))
                    dfs(i, j, island_count)
                    island_count += 1
                if island_count == 2:
                    break

        # Initialize a queue with the cells from the first island
        queue = list(islands[0])

        # Initialize the distance and keep track of visited cells
        distance = -1
        seen = islands[0].copy()

        # Breadth-first search to find the shortest bridge
        while queue:
            next_queue = []
            for cell in queue:
                # Check if the cell is part of the second island
                if cell in islands[1]:
                    return distance

                # Explore the neighboring cells
                for k in range(4):
                    new_row, new_col = cell[0] + DIRECTIONS[k], cell[1] + DIRECTIONS[k+1]
                    # Check if the new cell is within bounds and has not been visited
                    if 0 <= new_row < rows and 0 <= new_col < cols and (new_row, new_col) not in seen:
                        # Add the new cell to the queue and mark it as visited
                        next_queue.append((new_row, new_col))
                        seen.add((new_row, new_col))

            # Update the queue and distance for the next iteration
            queue = next_queue
            distance += 1

        # If no bridge is found, return the distance
        return distance