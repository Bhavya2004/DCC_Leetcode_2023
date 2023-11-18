import java.util.Arrays;

public class Frequency_of_the_Most_Frequent_Element {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int maxFreq = 0;
        long sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum + k < (long) nums[right] * (right - left + 1)) {
                sum -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int k = 5;
        int maxFreq = maxFrequency(nums, k);
        System.out.println("Maximum Frequency: " + maxFreq);
    }
}
