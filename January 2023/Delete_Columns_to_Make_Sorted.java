class Solution {
    public int minDeletionSize(String[] A) {
        if(A == null || A.length == 0)
            return 0;

        int res = 0;
        int n = A[0].length();

        for(int i = 0; i < n; i++) {
            int j = 0;
            for(; j < A.length - 1; j++) {
                if(A[j].charAt(i) > A[j + 1].charAt(i)) {
                    break;
                }
            }

            if(j != A.length - 1)
                res++;
        }

        return res;
    }

}