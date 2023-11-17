import java.util.Arrays;

public class Minimize_Maximum_Pair_Sum_in_Array {
    public static int minimizeMaxPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = Integer.MIN_VALUE;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, pairSum);
            left++;
            right--;
        }

        return maxPairSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 4, 4};
        int minimizedMaxPairSum = minimizeMaxPairSum(nums);
        System.out.println("Minimized Maximum Pair Sum: " + minimizedMaxPairSum);
    }
}
