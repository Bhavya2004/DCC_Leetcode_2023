MOD = 10 ** 9 + 7
class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        """
        n unique songs, g = number of songs in a playlist, k = cooldown
        """
        g = goal
        if (n > g) or (k >= n): # playlist too small or cooldown too long
            return 0

        # 1. Pick the first k songs in any way; different order => different combo
        first_k_ways = 1
        for i in range(n, n - k, -1):
            first_k_ways = (first_k_ways * i) % MOD

        rem_songs = g - k
        # 2. Figure out the rest, given we've picked the first k
        self._dp = {(0, 0): 1}
        self._n = n
        self._k = k
        ways = self.solve(rem_songs, n - k)
        # 3. aggregate results
        # print(f"{(first_k_ways, ways)}")
        res = (first_k_ways * ways) % MOD
        return res

    def solve(self, r, t):
        """
        How many playlists can we form given that we have r remaining songs and 
        require t more unique ones to be placed into the playlist?
        """
        pair = (r, t)
        if pair in self._dp:
            return self._dp[pair]
        if r < t: # we need to put t songs into the playlist, but only r open slots!
            self._dp[pair] = 0
            return self._dp[pair]

        res = 0
        able = self._n - self._k
        if t == 0: # because no required songs are needed at this point, we can pick any of the not-last-k songs
            res = (able * self.solve(r - 1, 0)) % MOD
        else: # at least one song that hasn't been used yet can be selected here
            res = (t * self.solve(r - 1, t - 1)) % MOD # select the not-used song
            able_and_unused = able - t # select some song that IS available due to cooldown but has been chosen already
            if able_and_unused > 0:
                res = (res + able_and_unused * self.solve(r - 1, t)) % MOD

        self._dp[pair] = res
        return self._dp[pair]