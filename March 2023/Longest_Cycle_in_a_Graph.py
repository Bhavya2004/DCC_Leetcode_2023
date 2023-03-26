class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        longest_cycle_len = -1
        time_step = 1
        node_visited_at_time = [0] * len(edges)

        for current_node in range(len(edges)):
            if node_visited_at_time[current_node] > 0:
                continue
            start_time = time_step
            u = current_node
            while u != -1 and node_visited_at_time[u] == 0:
                node_visited_at_time[u] = time_step
                time_step += 1
                u = edges[u]
            if u != -1 and node_visited_at_time[u] >= start_time:
                longest_cycle_len = max(longest_cycle_len, time_step - node_visited_at_time[u])

        return longest_cycle_len