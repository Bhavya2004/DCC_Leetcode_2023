class Solution {
    public int getWinner(int[] arr, int k) {
        int i = 0, j = 1, count = 0, currentWinner = arr[i];

        while (count < k) {
            if (arr[i] > arr[j]) {
                count++;
                j++;

                if (count == k) {
                    return currentWinner;
                }
            } else {
                count = 1;
                currentWinner = arr[j];
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }

            if (j == arr.length) {
                i = 0;
                j = 1;
            }
        }

        return currentWinner;
    }
}
