class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        maxAchievable = 0

        for i in range(2**len(requests)):
            combination = []
            for j in range(len(requests)):
                if (i >> j) & 1:
                    combination.append(requests[j])

            buildingDiff = [0] * n

            for request in combination:
                fromi, toi = request
                buildingDiff[fromi] += 1
                buildingDiff[toi] -= 1

            valid = True
            for diff in buildingDiff:
                if diff != 0:
                    valid = False
                    break

            if valid:
                maxAchievable = max(maxAchievable, len(combination))

        return maxAchievable