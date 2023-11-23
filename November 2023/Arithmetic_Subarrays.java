import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic_Subarrays {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        
        for (int i = 0; i < l.length; i++) {
            int[] subarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            result.add(isArithmeticSequence(subarray));
        }
        
        return result;
    }
    
    private static boolean isArithmeticSequence(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }
        
        return true;
    }
}
