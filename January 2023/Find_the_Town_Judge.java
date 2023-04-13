class Solution {
    public int findJudge(int n, int[][] trust) {
        // indegree of a vertex represents number of people who trusts him
        // outdegree of a vertex represents number of people whom he trusts
        // Therefore we have to find a vertex who's outdegree is zero 
        if (trust.length == 0 && n == 1) 
            return 1;
        int[] count = new int[n + 1];
        for (int[] person : trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for (int person = 0; person < count.length; person++) {
            if (count[person] == n - 1) return person;
        }
        return -1;
    }
}