//deviation=max-min.We need to reduce this deviation by performing two operations given.
//we can reduce deviation by decreasing the max number and increasing the min number.
//step-1 is to multiply all the odd numbers by 2 once to make it even
//step-2 take the min element after multiplying
//step-3 After multiplying all odd's by 2 we will push all the elements one by one to a max heap which will give us the max element in the array
//step-3 pop the max element which will be a even number and calculate the diff=max-min 
//step-4 perform the divide/2 operation to reduce the max element and again push the max element into max heap and repeat the steps
//note that repeat the above process until the max element is even.As soon as the max element popped from max heap will be odd,return the current diff as it will be the min diff.
//also check that after dividing the max ele by 2 it does not become smaller than min 
class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1)
                num = num * 2;
            pq.offer(num);
            minVal = Math.min(minVal, num);
        }
        int minDeviation = Integer.MAX_VALUE;
        while (true) {
            int maxVal = pq.poll();
            minDeviation = Math.min(minDeviation, maxVal - minVal);
            if (maxVal % 2 == 1)
                break;
            maxVal = maxVal / 2;
            minVal = Math.min(minVal, maxVal);
            pq.offer(maxVal);
        }
        return minDeviation;
    }
}